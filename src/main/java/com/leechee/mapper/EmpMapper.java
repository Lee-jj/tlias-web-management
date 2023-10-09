package com.leechee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.leechee.pojo.Emp;

@Mapper
public interface EmpMapper {
    
    // @Select("select count(*) from emp")
    // public Long count();

    // @Select("select * from emp limit #{start}, #{pageSize}")
    // public List<Emp> page(Integer start, Integer pageSize);

    // 使用PageHelper插件简化上述操作，进行正常查询即可
    // @Select("select * from emp")
    public List<Emp> list();
}
