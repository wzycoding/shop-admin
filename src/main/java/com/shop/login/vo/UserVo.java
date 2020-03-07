package com.shop.login.vo;

import lombok.Data;

@Data
public class UserVo {
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态
     */
    private boolean state;

    /**
     * 角色名称
     */
    private String roleName;
}
