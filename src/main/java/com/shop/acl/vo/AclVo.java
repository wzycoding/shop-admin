package com.shop.acl.vo;

import lombok.Data;

@Data
public class AclVo {
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
}
