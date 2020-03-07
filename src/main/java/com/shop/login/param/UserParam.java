package com.shop.login.param;

import lombok.Data;

@Data
public class UserParam {
    private long id;

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

}
