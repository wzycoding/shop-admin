package com.shop.menu.service.impl;

import com.shop.menu.mapper.SysMenu;
import com.shop.menu.mapper.SysMenuMapper;
import com.shop.menu.mapper.SysMenuNode;
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
    public List<SysMenuNode> getMenuList() {
        List<SysMenu> sysMenuList = sysMenuMapper.findAll();
        List<SysMenuNode> sysMenuNodeList = new ArrayList<>();
        Map<Integer, List<SysMenu>> levelIndexMap = sysMenuList.stream().collect(Collectors.groupingBy(SysMenu::getLevelIndex));
        Map<Integer, List<SysMenu>> parentIdMap = sysMenuList.stream().collect(Collectors.groupingBy(SysMenu::getParentId));

        List<SysMenu> rootSysMenus = levelIndexMap.get(0);
        for (SysMenu sysMenu : rootSysMenus) {
            SysMenuNode sysMenuNode = new SysMenuNode();
            sysMenuNode.setAuthName(sysMenu.getAuthName());
            sysMenuNode.setLevelIndex(sysMenu.getLevelIndex());
            sysMenuNode.setParentId(sysMenu.getParentId());
            sysMenuNode.setPath(sysMenu.getPath());
            sysMenuNode.setId(sysMenu.getId());

            sysMenuNode.setChildren(parentIdMap.get(sysMenu.getId()));
            sysMenuNodeList.add(sysMenuNode);
        }

        return sysMenuNodeList;
    }

    @Resource
    SysMenuMapper sysMenuMapper;
}
