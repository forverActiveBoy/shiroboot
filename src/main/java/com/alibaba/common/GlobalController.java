package com.alibaba.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Locale;

/**
 * @function 控制器增强类
 */
@ControllerAdvice
public class GlobalController {
    @Autowired
    private MessageSource messageSource;

    /**
     * @ResponseBody：将数据以json的形式返回
     * @ExceptionHandler：作用在所有被@RequestMapping修饰的方法上
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public GlobalResponse exceptionHandler(Exception e) {
        Locale local =  LocaleContextHolder.getLocale();
        //  参数说明：
        //  参数一：获取http状态码的500值
        //  参数二：从配置文件获取异常信息
        return new GlobalResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),messageSource.getMessage("common.server.error",null,local));
    }

    /**
     * @ResponseBody：将数据以json的形式返回
     * @ExceptionHandler：作用在所有被@RequestMapping修饰的方法上
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public GlobalResponse CustomExceptionHandler(CustomException e) {
        return new GlobalResponse(e.getCode(), e.getMessage());
    }
}
