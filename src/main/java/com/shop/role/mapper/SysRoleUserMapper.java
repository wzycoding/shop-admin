package com.shop.role.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleUserMapper {

    @Insert(" insert into sys_role_user(user_id, role_id, create_time, updated_time) " +
            " values(#{userId}, #{roleId}, #{createTime}, #{updateTime})")
    int insert(SysRoleUser roleUser);


    @Select(" select * from sys_role_user where user_id = #{userId}")
    List<SysRoleUser> getByUserId(long userId);

}
