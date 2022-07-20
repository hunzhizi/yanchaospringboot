package com.hunzhizi.dao;

import com.hunzhizi.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-12 13:10
 * @description:
 */
@Mapper
public interface UserDao {
    /**
     * 存储用户信息
     *
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    boolean update(User user);


    /**
     * 根据uuid获取用户
     *
     * @param userId
     * @return
     */
    User get(Integer userId);


}
