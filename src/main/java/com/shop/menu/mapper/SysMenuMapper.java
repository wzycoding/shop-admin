package com.shop.menu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    @Select("select * from sys_menu where `deleted` = 0")
    List<SysMenu> findAll();
}
