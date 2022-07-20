package com.hunzhizi.interceptor;


import com.hunzhizi.controller.results.Result;
import com.hunzhizi.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-29 20:18
 * @description:
 */
@ControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    //对出现异常的情况进行拦截，并将其处理成统一的页面数据结果格式
    public Result doBussinessException(BusinessException e) {
        return new Result(e.getCode(), e.getMessage());
    }
}
