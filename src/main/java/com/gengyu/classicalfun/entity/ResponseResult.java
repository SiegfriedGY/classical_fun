package com.gengyu.classicalfun.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;
}
