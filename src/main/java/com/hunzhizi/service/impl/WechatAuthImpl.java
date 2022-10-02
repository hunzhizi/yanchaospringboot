package com.hunzhizi.service.impl;

import com.hunzhizi.dao.UserDao;
import com.hunzhizi.dao.WechatAuthDao;
import com.hunzhizi.domain.User;
import com.hunzhizi.domain.WechatAuth;
import com.hunzhizi.exception.BusinessException;
import com.hunzhizi.service.WechatAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2022-08-26 13:54
 * program: yanchaospringboot
 * description:
 */
@Service
public class WechatAuthImpl implements WechatAuthService {
    @Resource
    WechatAuthDao authDao;
    @Resource
    UserDao userDao;
    @Override
    public User getUserByOpenId(String openId) {
        //首先先查找该openid是否存在，存在则返回对应user ，不存在则创建user后再返回user
        WechatAuth wechatAuthByOpenId = authDao.getWechatAuthByOpenId(openId);
        if(wechatAuthByOpenId == null){
            //如果该openid 在数据库中暂时不存在，说明该用户首次使用，需要对用户进行创建
            User user = new User();
            boolean save = userDao.save(user);
            WechatAuth wechatAuth = new WechatAuth();
            System.out.println(user.getUserId());
            wechatAuth.setUserId(user.getUserId());
            wechatAuth.setOpenId(openId);
            Boolean insert = authDao.insert(wechatAuth);
            wechatAuthByOpenId = wechatAuth;
            if(!save || !insert) {
                throw new BusinessException(-1);
            }
        }
        return userDao.get(wechatAuthByOpenId.getUserId());
    }
}
