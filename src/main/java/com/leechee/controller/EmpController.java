package com.leechee.controller;

import org.springframework.web.bind.annotation.RestController;

import com.leechee.pojo.Result;
import com.leechee.pojo.PageBean;
import com.leechee.service.EmpService;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @GetMapping(value="/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Short gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询，参数: {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);

        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        
        return Result.success(pageBean);
    }
    
    @DeleteMapping("emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除员工，参数: {}", ids);

        empService.delete(ids);

        return Result.success();
    }
}
