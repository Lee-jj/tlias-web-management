package com.leechee.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leechee.mapper.DeptMapper;
import com.leechee.pojo.Dept;
import com.leechee.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 补充基本属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        // 调用Mapper层
        deptMapper.insert(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void change(Dept dept) {
        // 补充基本属性
        dept.setUpdateTime(LocalDateTime.now());

        // 调用Mapper层
        deptMapper.change(dept);
    }
    
}
