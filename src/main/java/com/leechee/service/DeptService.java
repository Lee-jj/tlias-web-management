package com.leechee.service;

import java.util.List;

import com.leechee.pojo.Dept;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add (Dept dept);

    Dept get(Integer id);

    void change(Dept dept);
}
