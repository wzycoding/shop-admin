package com.shop.menu.mapper;

import lombok.Data;

import java.util.Date;

/**
 * 菜单实体类
 */
@Data
public class SysMenu {
    /**
     * id
     */
    private Integer id;
    /**
     * 菜单名称
     */
    private String authName;
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 层级索引
     */
    private Integer levelIndex;
    /**
     * 菜单路径
     */
    private String path;
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
    private Integer delete;
}
