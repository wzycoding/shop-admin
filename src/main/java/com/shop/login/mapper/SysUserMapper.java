package com.shop.login.mapper;

import com.shop.login.param.UserParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户表mapper
 */
@Mapper
public interface SysUserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into sys_user(username, password, email, avatar, nickname, phone, create_time, last_login_time, `deleted`) " +
            "values(#{username}, #{password}, #{email}, #{avatar}, #{nickname}, #{phone}, #{createTime}, #{lastLoginTime}, #{deleted})")
    int insert(SysUser user);

    @Select("select * from sys_user where username = #{username} and password = #{password} and `deleted` = 0 and enable = 1")
    SysUser get(String username, String password);

    @Select("select * from sys_user " +
            "where username like '%${query}%' and `deleted` = 0 limit #{skip}, #{pageSize}")
    List<SysUser> findUsers(int pageSize, int skip, String query);

    @Select("select count(*) from sys_user where `deleted` = 0 and username like '%${query}%'")
    int countUsers(@Param("query") String query);

    @Update("update sys_user set `enable` = #{enable} where id = #{id}")
    int updateUserState(long id, int enable);

    @Select("select * from sys_user where id = #{id}")
    SysUser getById(long id);

    @Update("update sys_user set phone = #{phone}, email = #{email} where id = #{id}")
    int updateUser(UserParam param);

    @Update("update sys_user set `deleted` = 1 where id = #{id}")
    int delete(long id);
}
