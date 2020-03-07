package com.shop.role.mapper;

import lombok.Data;

import java.util.Date;

/**
 * 角色与权限关系表实体类
 */
@Data
public class RoleUser {
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private long userId;
    /**
     * 角色id
     */
    private long roleId;
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
