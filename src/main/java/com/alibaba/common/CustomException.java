package com.alibaba.common;

/**
 * @function 统一的异常处理类
 */
public class CustomException extends RuntimeException{
    /**
     * 用的最多的状态码
     */
    private int code = 400;

    public CustomException(){
    }

    public CustomException(int code, String message){
        super(message);
        this.code = code;
    }

    public CustomException(String message){
        super(message);
    }

    public CustomException(int code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    //  --------------以下一系列的pop方法封装了各种抛异常的动作-------------
    /**
     * 抛异常的方法
     * @param message
     */
    static public void pop(String message){
        throw new CustomException(message);
    }

    static public void pop(int code, String message){
        throw new CustomException(code, message);
    }

    static public void pop(int code, String message, Throwable cause){
        throw new CustomException(code, message, cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
