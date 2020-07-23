package com.lzy.www.client.feign;

import com.lzy.www.client.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeginFailBackImpl implements UserFeignClient{

    @Override
    public User findById(Long id) {
        System.out.println("熔断，默认回调函数");
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
