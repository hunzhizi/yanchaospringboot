package com.hunzhizi.service.impl;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.MyCollectionDao;
import com.hunzhizi.dao.PostDao;
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
    @Resource
    PostDao postDao;
    @Override
    public boolean insert(Integer userId, Integer postId) {
        Post post = new Post();
        //让post 的commentNum 数量加1
        post.setCollectionNum(1);
        post.setPostId(postId);
        boolean b = postDao.updatePost(post);
        return b && myCollectionDao.insert(userId,postId);
    }

    @Override
    public boolean delete(Integer userId, Integer postId) {
        Post post = new Post();
        post.setPostId(postId);
        post.setCollectionNum(2);
        boolean b = postDao.updatePost(post);
        //讲post 的commentNum 数量减一
        return b && myCollectionDao.delete(userId, postId);
    }

    @Override
    public PageInfo<Post> getCollectionsByUserId(Integer userId) {
        List<Post> collectionsByUser = myCollectionDao.getCollectionsByUser(userId);
        return new PageInfo<>(collectionsByUser);
    }
}
