package com.shop.acl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AclMapper {

    @Select("select * from acl")
    List<Acl> getAll();
}
