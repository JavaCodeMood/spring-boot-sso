package com.lhf.springboot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: BaseResponse
 * @Author: liuhefei
 * @Description: TODD
 * @Date: 2019/7/18 16:59
 */
@Data
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -3862428020743870898L;

    public static final int SUCCESS_CODE = 200;
    public static final int FAILURE_CODE = 500;


    private int code;

    private String message;

    private boolean success;

    private T data;

    public BaseResponse(T data) {
        this.code = SUCCESS_CODE;
        this.success = true;
        this.data = data;
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.success = code == SUCCESS_CODE ? true : false;
        this.data = data;
    }



}
