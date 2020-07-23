package com.lzy.www.client.user;

import com.lzy.www.client.entity.User;
import com.lzy.www.client.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "getDefaultUser", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public User findById(@PathVariable Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        User user = this.userFeignClient.findById(id);
        return user;
    }

    public User getDefaultUser(Long id) {
        System.out.println("熔断，默认回调函数");
        User user = new User();
        user.setId(-12L);
        return user;
    }
}