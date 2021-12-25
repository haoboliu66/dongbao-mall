package com.msb.dongbao.common.base;

/**
 * Response code
 */
public enum StateCodeEnum {

    SUCCESS(200, "Success"),
    FAILURE(500, "Failure"),
    PASSWORD_ERROR(1001,"Incorrect Password"),
    USER_EMPTY(1002,"User doesn't exist"),
    TOKEN_ERROR(501, "Token Error"),
    INVALID_REQUEST(401, "Invalid Request");

    private int code;
    private String msg;

    StateCodeEnum(int code){
        this.code = code;
    }

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
