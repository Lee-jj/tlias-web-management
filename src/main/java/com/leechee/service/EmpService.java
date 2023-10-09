package com.leechee.service;

import java.time.LocalDate;

import com.leechee.pojo.PageBean;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    
}
