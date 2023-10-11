package com.leechee.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.leechee.pojo.Emp;

@Mapper
public interface EmpMapper {
    
    // @Select("select count(*) from emp")
    // public Long count();

    // @Select("select * from emp limit #{start}, #{pageSize}")
    // public List<Emp> page(Integer start, Integer pageSize);

    // 使用PageHelper插件简化上述操作，进行正常查询即可
    // @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    public void deleteById(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) "  + 
            "value (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    public Emp getUserById(Integer id);

    public void update(Emp emp);
}
