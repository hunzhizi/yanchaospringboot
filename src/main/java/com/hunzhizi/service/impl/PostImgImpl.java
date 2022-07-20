package com.hunzhizi.service.impl;

import com.hunzhizi.dao.PostImgDao;
import com.hunzhizi.domain.PostImg;
import com.hunzhizi.service.PostImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @since 2022-06-03 20:51
 * program: yanchaospringboot
 * description:
 */
@Service
public class PostImgImpl implements PostImgService {
    @Resource
    private PostImgDao postImgDao;
    @Override
    public boolean insert(PostImg postImg) {
        return postImgDao.insert(postImg);
    }

    @Override
    public boolean delete(Integer postId) {
        return postImgDao.deleteByPostId(postId);
    }

    @Override
    public List<PostImg> selectByPostId(Integer postId) {
        return postImgDao.selectByPostId(postId);
    }
}
