package com.yp.springbase.base.framework;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseResult<T> {

    private int code;

    private String message;

    private T data;

    private ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, "成功", data);
    }

    public static <T> ResponseResult<T> failed() {
        return new ResponseResult<>(500, "失败", null);
    }

}
