package com.shop.login.mapper;

import com.shop.login.param.UserParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户表mapper
 */
@Mapper
public interface UserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into user(username, password, email, avatar, nickname, phone, create_time, last_login_time, `delete`) " +
            "values(#{username}, #{password}, #{email}, #{avatar}, #{nickname}, #{phone}, #{createTime}, #{lastLoginTime}, #{delete})")
    int insert(User user);

    @Select("select * from user where username = #{username} and password = #{password} and `delete` = 0")
    User get(String username, String password);

    @Select("select * from user " +
            "where username like '%${query}%' limit #{skip}, #{pageSize}")
    List<User> findUsers(int pageSize, int skip, String query);

    @Select("select count(*) from user where `delete` = 0 and username like '%${query}%'")
    int countUsers(@Param("query") String query);

    @Update("update user set `delete` = #{delete} where id = #{id}")
    int updateUserState(long id, int delete);

    @Select("select * from user where id = #{id}")
    User getById(long id);

    @Update("update user set phone = #{phone}, email = #{email} where id = #{id}")
    int updateUser(UserParam param);

    @Update("update user set `delete` = 1 where id = #{id}")
    int delete(long id);
}
