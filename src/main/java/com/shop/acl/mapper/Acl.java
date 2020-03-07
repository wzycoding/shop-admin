package com.shop.acl.mapper;

import lombok.Data;

import java.util.Date;

/**
 * 权限表实体类
 */
@Data
public class Acl {
    /**
     * id
     */
    private long id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;
    /**
     * 权限等级：1，2，3分别代表一二三级权限
     */
    private int level;
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
