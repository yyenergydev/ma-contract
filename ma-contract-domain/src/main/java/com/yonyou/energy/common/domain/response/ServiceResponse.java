package com.yonyou.energy.common.domain.response;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = 2488663702267110932L;
    private String code;
    private String msg;
    private String detail;
    private T result;

    public static ServiceResponse successResponse() {
        return new ServiceResponse(BaseResponseCode.SUCCESS);
    }

    public static ServiceResponse failureResponse() {
        return new ServiceResponse(BaseResponseCode.FAILURE);
    }

    public ServiceResponse() {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
    }

    public ServiceResponse(T result) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.result = result;
    }

    public ServiceResponse(String code, String msg) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = code;
        this.msg = msg;
    }

    public ServiceResponse(String code, String msg, String detail) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public ServiceResponse(ResponseCode ResponseCode) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
    }

    public ServiceResponse(ResponseCode ResponseCode, String detail) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
        this.detail = detail;
    }

    public void setResponseCode(ResponseCode ResponseCode) {
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
    }

    public boolean isSuccess() {
        return BaseResponseCode.SUCCESS.getCode().equals(this.code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public void addDetail(String detail) {
        this.setDetail(detail);
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
