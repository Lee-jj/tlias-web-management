package com.leechee.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leechee.mapper.EmpMapper;
import com.leechee.pojo.Emp;
import com.leechee.pojo.PageBean;
import com.leechee.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    // @Override
    // public PageBean page(Integer page, Integer pageSize) {
    //     Long count = empMapper.count();
        
    //     Integer start = (page - 1) * pageSize;
    //     List<Emp> empList =  empMapper.page(start, pageSize);
        
    //     PageBean pageBean = new PageBean(count, empList);
    //     return pageBean;
    // }

    // 使用PageHelper插件简化上述操作
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        
        // 执行查询操作
        Page<Emp> p = (Page<Emp>) empMapper.list(name, gender, begin, end);

        // 封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteById(ids);        
    }

    
}
