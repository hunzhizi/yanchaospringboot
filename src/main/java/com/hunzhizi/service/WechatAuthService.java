package com.hunzhizi.service;

import com.hunzhizi.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 魂之子
 * @since 2022-08-26 13:52
 * program: yanchaospringboot
 * description:
 */

public interface WechatAuthService {
    @Transactional
    User getUserByOpenId(String openId);
}
