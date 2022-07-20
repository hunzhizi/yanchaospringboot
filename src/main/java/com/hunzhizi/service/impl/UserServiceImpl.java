package com.hunzhizi.service.impl;

import com.hunzhizi.controller.results.Code;
import com.hunzhizi.dao.UserDao;
import com.hunzhizi.domain.User;
import com.hunzhizi.exception.BusinessException;
import com.hunzhizi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @program: springMVC
 * @create: 2022-04-12 13:15
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getUserId() == null) {
            throw new BusinessException(Code.PASS_VALUE_ERR);
        }
        //如果举报数量大于5则，禁用用户
        if (user.getReportNum() != null && user.getReportNum() >= 5) {
            user.setForbidden(true);
        }
        return userDao.update(user);
    }


    @Override
    public User getUserById(Integer uuid) {
        return userDao.get(uuid);
    }

//    @Override
//    public PageInfo<User> getAll(int page, int size) {
//        PageHelper.startPage(page,size);
//        List<User> all = userDao.getAll();
//        return new PageInfo<User>(all);
//    }

}
