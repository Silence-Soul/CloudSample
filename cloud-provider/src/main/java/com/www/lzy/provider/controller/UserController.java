package com.www.lzy.provider.controller;

import com.www.lzy.provider.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
//        int timeout = 2000;
//        try { TimeUnit.MILLISECONDS.sleep(timeout); }catch (Exception e){ e.printStackTrace(); }
        User findOne = new User();
        if (id == 1) {
            findOne.setAge(20);
            findOne.setName("zhangsan");
            findOne.setUsername("zhangsan");
            findOne.setId(1L);
            findOne.setBalance(800D);
        } else {
            findOne.setAge(18);
            findOne.setName("lisi");
            findOne.setUsername("lisi");
            findOne.setId(2L);
            findOne.setBalance(2000D);
        }
        return findOne;
    }
}
