package com.hunzhizi.service.impl;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.MyCollectionDao;
import com.hunzhizi.domain.Post;
import com.hunzhizi.service.MyCollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @since 2022-05-31 14:33
 * program: yanchaospringboot
 * description:
 */
@Service
public class MyCollectionImpl implements MyCollectionService {

    @Resource
    MyCollectionDao myCollectionDao;
    @Override
    public boolean insert(Integer userId, Integer postId) {
        return myCollectionDao.insert(userId,postId);
    }

    @Override
    public boolean delete(Integer userId, Integer postId) {
        return myCollectionDao.delete(userId, postId);
    }

    @Override
    public PageInfo<Post> getCollectionsByUserId(Integer userId) {
        List<Post> collectionsByUser = myCollectionDao.getCollectionsByUser(userId);
        return new PageInfo<>(collectionsByUser);
    }
}
