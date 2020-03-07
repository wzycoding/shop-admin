package com.shop.menu.mapper;

import lombok.Data;

import java.util.List;

@Data
public class MenuNode {
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
     * 子菜单
     */
    private List<Menu> children;
}
