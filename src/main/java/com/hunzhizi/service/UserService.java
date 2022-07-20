package com.hunzhizi.service;

import com.hunzhizi.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 魂之子
 * @program: springMVC
 * @create: 2022-04-12 13:15
 * @description:
 */
@Transactional(
        readOnly = true
)
public interface UserService {
    /**
     * 增添用户信息
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = false)
    boolean addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = false)
    boolean updateUser(User user);


    /**
     * 根据uuid获取用户
     *
     * @param userId
     * @return
     */
    User getUserById(Integer userId);


}
