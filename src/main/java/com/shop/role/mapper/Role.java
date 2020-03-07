package com.shop.role.mapper;

import lombok.Data;

import java.util.Date;

/**
 * 角色表实体类
 */
@Data
public class Role {
    /**
     * id
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色类型：0超级管理员，1其他
     */
    private int type;
    /**
     * 优先级，0是最高优先级
     */
    private int seq;
    /**
     * 角色备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 删除标记
     */
    private int delete;
}
