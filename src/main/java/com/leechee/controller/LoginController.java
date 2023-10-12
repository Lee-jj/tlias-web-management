package com.leechee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leechee.pojo.Emp;
import com.leechee.pojo.Result;
import com.leechee.service.EmpService;
import com.leechee.utils.JwtUtils;

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

        // 登录成功，生成并下发令牌
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(null);
            return Result.success(jwt);
        }

        // 登录失败
        return Result.error("用户名或密码错误");
    }
}
