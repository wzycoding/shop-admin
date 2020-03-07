package com.shop.role.mapper;

import com.shop.login.mapper.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Insert("insert into role(name, type, seq, remark, create_time, updated_time, `delete`)" +
            " values(#{name}, #{type}, #{seq}, #{remark}, #{createTime}, #{updatedTime}, #{delete})")
    int insert(User user);

    @Select("select * from role")
    List<Role> getAll();

    @Update("<script> " +
            "update role " +
            "<set> " +
            "<if test=\"name != null\">name=#{name},</if> " +
            "<if test=\"type != null\">type=#{type},</if> " +
            "<if test=\"seq != null\">seq=#{seq}</if> " +
            "<if test=\"remark != null\">seq=#{remark}</if> " +
            "</set> " +
            "where id = #{id} " +
            "</script> ")
    int update(Role role);

    @Update("update role set `delete` = 1 where id = #{id}")
    int delete(long id);

    @Select("select * from role where id = #{id}")
    int findById(long id);

}
