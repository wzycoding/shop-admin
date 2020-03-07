package com.shop.login.param;

import lombok.Data;

/**
 * 登录入参
 */
@Data
public class LoginParam {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
