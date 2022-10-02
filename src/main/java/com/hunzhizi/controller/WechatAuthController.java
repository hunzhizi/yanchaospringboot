package com.hunzhizi.controller;

import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.User;
import com.hunzhizi.service.WechatAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2022-08-26 14:10
 * program: yanchaospringboot
 * description:
 */
@RestController
@RequestMapping("/auth")
public class WechatAuthController {
    @Resource
    WechatAuthService authService;
    @PostMapping
    public Result auth(String openId){
        User user = authService.getUserByOpenId(openId);
        return new Result(Code.WECHATAUTH_GET_OK,user);
    }

}
