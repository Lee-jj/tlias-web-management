package com.leechee.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 部门实体类
// lombok 注解
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;                 // ID
    private String name;                // 部门名称
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 修改时间
}
