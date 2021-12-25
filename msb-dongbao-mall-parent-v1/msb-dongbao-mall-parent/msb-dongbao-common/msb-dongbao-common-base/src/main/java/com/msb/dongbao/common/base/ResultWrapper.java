package com.msb.dongbao.common.base;

import lombok.Builder;
import lombok.Data;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.io.Serializable;

@Data
@Builder
public class ResultWrapper<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public ResultWrapper(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * Continue to append .data() when the object is returned by controller
     * @return
     */
    public static ResultWrapperBuilder getSucessBuilder(){
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }

    public static ResultWrapperBuilder getFailureBuilder(){
        return ResultWrapper.builder().code(StateCodeEnum.FAILURE.getCode()).msg(StateCodeEnum.FAILURE.getMsg());
    }

}
