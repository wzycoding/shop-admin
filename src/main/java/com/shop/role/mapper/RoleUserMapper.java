package com.shop.role.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleUserMapper {

    @Insert(" insert into role_user(user_id, role_id, create_time, updated_time) " +
            " values(#{userId}, #{roleId}, #{createTime}, #{updateTime})")
    int insert(RoleUser roleUser);


    @Select(" select * from role_user where user_id = #{userId}")
    List<RoleUser> getByUserId(long userId);

}
