package com.shop.common.vo;

import com.shop.common.constants.ErrorEnum;
import lombok.Data;

@Data
public class Result<T> {
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }

    public static <T> Result success(T data) {
        Result<T> resultVo = new Result<T>(0, "");
        resultVo.setData(data);
        return resultVo;
    }
    public static <T> Result success() {
        return new Result<T>(0, "");
    }

    public static <T> Result error(ErrorEnum errorEnum) {
        return new Result<T>(errorEnum.getCode(), errorEnum.getMsg());
    }

}
