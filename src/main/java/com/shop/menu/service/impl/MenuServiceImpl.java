package com.shop.menu.service.impl;

import com.shop.menu.mapper.Menu;
import com.shop.menu.mapper.MenuMapper;
import com.shop.menu.mapper.MenuNode;
import com.shop.menu.service.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements IMenuService {
    @Override
    public List<MenuNode> getMenuList() {
        List<Menu> menuList = menuMapper.findAll();
        List<MenuNode> menuNodeList = new ArrayList<>();
        Map<Integer, List<Menu>> levelIndexMap = menuList.stream().collect(Collectors.groupingBy(Menu::getLevelIndex));
        Map<Integer, List<Menu>> parentIdMap = menuList.stream().collect(Collectors.groupingBy(Menu::getParentId));

        List<Menu> rootMenu = levelIndexMap.get(0);
        for (Menu menu : rootMenu) {
            MenuNode menuNode = new MenuNode();
            menuNode.setAuthName(menu.getAuthName());
            menuNode.setLevelIndex(menu.getLevelIndex());
            menuNode.setParentId(menu.getParentId());
            menuNode.setPath(menu.getPath());
            menuNode.setId(menu.getId());

            menuNode.setChildren(parentIdMap.get(menu.getId()));
            menuNodeList.add(menuNode);
        }

        return menuNodeList;
    }

    @Resource
    MenuMapper menuMapper;
}
