package com.hunzhizi.domain;

import java.util.Date;

/**
 * @author 魂之子
 * @program: o2o
 * @create: 2022-04-23 23:40
 * @description: 创建本地账号
 */
public class WechatAuth {
    private Integer WechatAuthId;
    //     private String username;        日后可以做扩展
    //     private String password;
    private String openId;      //28位
    private Integer userId;

    public Integer getWechatAuthId() {
        return WechatAuthId;
    }

    public void setWechatAuthId(Integer wechatAuthId) {
        WechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
