package com.shop.acl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysAclMapper {

    @Select("select * from sys_acl")
    List<SysAcl> getAll();
}
