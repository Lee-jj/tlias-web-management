package com.leechee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.leechee.pojo.Dept;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> list();
}
