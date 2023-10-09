package com.leechee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leechee.pojo.Dept;
import com.leechee.pojo.Result;
import com.leechee.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 定义Logger的注解
@RestController
@RequestMapping("/depts")
public class DeptController {
    
    // private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;


    /**
     * 显示所有部门数据
     * @return
     */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping    // 使用注解对上进行简化
    public Result list() {
        log.info("查询全部的部门数据");

        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }


    /**
     * 根据id删除部门
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门: {}", id);

        // 调用service删除部门
        deptService.delete(id);

        return Result.success();
    }


    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门: {}", dept);

        // 调用service新增部门
        deptService.add(dept);

        return Result.success();
    }


    /**
     * 根据id查询部门
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询部门: {}", id);

        // 调用service查询部门，返回查询结果
        Dept dept = deptService.get(id);

        return Result.success(dept);
    }


    /**
     * 修改部门数据
     * @return
     */
    @PutMapping
    public Result change(@RequestBody Dept dept) {
        log.info("修改部门数据: {}", dept);

        // 调用service层修改部门数据
        deptService.change(dept);

        return Result.success();
    }
}
