package com.shop.login.mapper;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class User {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 删除标记
     */
    private int delete;


}
