package com.leechee.service;

import java.time.LocalDate;
import java.util.List;

import com.leechee.pojo.Emp;
import com.leechee.pojo.PageBean;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void insert(Emp emp);

    Emp getUserById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
    
}
