package com.leechee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leechee.pojo.Dept;
import com.leechee.pojo.Result;
import com.leechee.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 定义Logger的注解
@RestController
public class DeptController {
    
    // private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")     // 使用注解对上进行简化
    public Result list() {
        log.info("查询全部的部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }
}
