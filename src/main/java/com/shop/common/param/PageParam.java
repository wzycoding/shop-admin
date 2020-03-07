package com.shop.common.param;

import lombok.Data;

/**
 * 查询参数
 */
@Data
public class PageParam {
    /**
     * 每页多少条数据
     */
    private int pageSize;

    /**
     * 第几页
     */
    private int pageNum;

    /**
     * 查询条件
     */
    private String query;

    private int skip;

    public int getSkip() {
        return (pageNum - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

}
