package com.hunzhizi.controller.results;


/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-29 19:48
 * @description:
 */
public class Result {
    //操作结果编码
    private Integer code;
    //操作数据结果
    private Object data;
    //消息
    private String message;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
