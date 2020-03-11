package com.shop.acl.mapper;

import lombok.Data;

import java.util.Date;

/**
 * 权限角色表实体类
 */
@Data
public class SysAclRole {
    /**
     * id
     */
    private Long id;

    /**
     * 权限id
     */
    private long aclId;

    /**
     * 角色id
     */
    private long roleId;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 删除标记
     */
    private int delete;
}
