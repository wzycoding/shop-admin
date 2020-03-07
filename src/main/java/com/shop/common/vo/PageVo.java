package com.shop.common.vo;

import lombok.Data;

/**
 * 分页视图类
 */
@Data
public class PageVo<T> {
    /**
     * 总计多少条
     */
    private int total;

    /**
     * 返回数据
     */
    private T data;
}
