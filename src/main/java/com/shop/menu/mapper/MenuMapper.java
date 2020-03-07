package com.shop.menu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from menu where `delete` = 0")
    List<Menu> findAll();
}
