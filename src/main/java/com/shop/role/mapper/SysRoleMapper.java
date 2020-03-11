package com.shop.role.mapper;

import com.shop.login.mapper.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    @Insert("insert into sys_role(name, type, seq, remark, create_time, updated_time, `deleted`)" +
            " values(#{name}, #{type}, #{seq}, #{remark}, #{createTime}, #{updatedTime}, #{delete})")
    int insert(SysUser user);

    @Select("select * from sys_role")
    List<SysRole> getAll();

    @Update("<script> " +
            "update sys_role " +
            "<set> " +
            "<if test=\"name != null\">name=#{name},</if> " +
            "<if test=\"type != null\">type=#{type},</if> " +
            "<if test=\"seq != null\">seq=#{seq}</if> " +
            "<if test=\"remark != null\">seq=#{remark}</if> " +
            "</set> " +
            "where id = #{id} " +
            "</script> ")
    int update(SysRole role);

    @Update("update sys_role set `deleted` = 1 where id = #{id}")
    int delete(long id);

    @Select("select * from sys_role where id = #{id}")
    int findById(long id);

}
