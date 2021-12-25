package com.msb.dongbao.portal.web.advice;

import com.msb.dongbao.common.base.ResultWrapper;
import com.msb.dongbao.common.base.StateCodeEnum;
import com.msb.dongbao.common.base.exceptions.TokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public ResultWrapper handleTest(){
        System.out.println("Arithmetic Exception");
        return ResultWrapper.builder().code(301).data("hello handler").msg("Arithmetic exception").build();
    }

    @ExceptionHandler({TokenException.class})
    public ResultWrapper loginException(Exception e){
        return ResultWrapper.builder().code(StateCodeEnum.TOKEN_ERROR.getCode()).msg(e.getMessage()).build();
    }

}
