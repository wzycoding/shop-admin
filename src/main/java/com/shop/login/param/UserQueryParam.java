package com.shop.login.param;

import com.shop.common.param.PageParam;
import lombok.Data;

@Data
public class UserQueryParam extends PageParam {

    private long id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 删除标记
     */
    private int delete;

}
