package com.gj.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕捉
 *
 * 1.在类上添加 @ControllerAdvice 注解
 *
 * 2. 添加一个方法，方法上面添加 @ExceptionHandler 注解，如果返回类型是String或者json类型，
 *  则添加 @ResponseBody 注解
 *  方法中定义异常类型
 *
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 默认异常
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public String defaultExceptionHandler(Exception e){

        return "对不起服务器繁忙，请稍后再试！";
    }

    /**
     * 数学异常
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public String ArithmeticExceptionHandler(ArithmeticException e){

        return "数学异常！";
    }


}
