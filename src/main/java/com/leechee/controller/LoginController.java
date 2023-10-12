package com.leechee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leechee.pojo.Emp;
import com.leechee.pojo.Result;
import com.leechee.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("用户登录，参数{}", emp);

        Emp e = empService.login(emp);

        return e == null ? Result.error("用户名或密码错误") : Result.success();
    }
}
