package com.shop.menu.service;

import com.shop.menu.mapper.SysMenuNode;

import java.util.List;

public interface IMenuService {
    List<SysMenuNode> getMenuList();
}
