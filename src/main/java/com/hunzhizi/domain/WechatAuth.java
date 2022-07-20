package com.hunzhizi.domain;

import java.util.Date;

/**
 * @author 魂之子
 * @program: o2o
 * @create: 2022-04-23 23:40
 * @description: 创建本地账号
 */
public class WechatAuth {
    private Long WechatAuthId;
    //     private String username;        日后可以做扩展
//     private String password;
    private String openId;
    private Date createTime;
    private User user;

}
