package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.PostImg;

import java.util.List;

/**
 * @author 魂之子
 * @since 2022-06-03 20:49
 * program: yanchaospringboot
 * description:
 */
public interface PostImgService {
    boolean insert(PostImg postImg);
    boolean delete(Integer postId);
    List<String> selectByPostId(Integer postId);
}
