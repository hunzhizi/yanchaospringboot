package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 魂之子
 * @since 2022-05-31 14:31
 * program: yanchaospringboot
 * description:
 */
@Transactional
public interface MyCollectionService {
    boolean insert(Integer userId, Integer postId);

    boolean delete(Integer userId, Integer postId);

    PageInfo<Post> getCollectionsByUserId(Integer userId);
}
