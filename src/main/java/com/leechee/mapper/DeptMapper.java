package com.leechee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.leechee.pojo.Dept;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    public List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    public void insert(Dept dept);

    @Select("select * from dept where id = #{id}")
    public Dept getById(Integer id);

    // 在xml中使用动态sql进行修改操作
    public void change(Dept dept);
}
