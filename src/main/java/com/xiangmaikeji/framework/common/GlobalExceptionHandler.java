package com.xiangmaikeji.framework.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TY on 2017/6/15.
 */
@ControllerAdvice
//如果返回的为json数据或其它对象，添加该注解
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value=UndeclaredThrowableException.class)
    public ResponseData MethodArgumentNotValidHandler(HttpServletRequest request, UndeclaredThrowableException exception) throws Exception {
        return ResponseData.initError("签名校验失败",505L);
    }

    @ExceptionHandler(value=Exception.class)
    public  ResponseData defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {

        exception.printStackTrace();

        ResponseData responseData = ResponseData.initError(exception.getMessage(),500L);

        if (exception instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            responseData.setErrorCode(404L);
        } else {
            responseData.setErrorCode(500L);
        }

        return responseData;

    }

    @ExceptionHandler(value=XMException.class)
    public ResponseData XMExceptionHandler(HttpServletRequest request, XMException exception) throws Exception {
        return ResponseData.initError(exception.getMessage(),Long.valueOf(exception.getErrorCode()));
    }


}
