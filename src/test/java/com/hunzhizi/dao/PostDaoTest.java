package com.hunzhizi.dao;


import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.Post;
import com.hunzhizi.domain.PostImg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-02 10:58
 * @description:
 */
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class PostDaoTest  {
    @Resource
    PostDao postDao;

    @Test
    public void createPost() {
        Post post = new Post();
        post.setContent("欢迎来到燕巢");
        post.setUserId(1);
        postDao.createPost(post);
    }

    @Test
    public void delPostByPostId() {

    }

    @Test
    public void updatePost() {

    }

    @Test
    public void getPostByUserId() {

        List<Post> posts = postDao.getPostByUserId(1);
        for (Post post : posts) {
            System.out.println(post.getContent());
            List<PostImg> imgAddrList = post.getImgAddrList();
            for (PostImg postImg : imgAddrList) {
                System.out.println(postImg);
            }
            System.out.println();
        }

    }

    @Test
    public void getPostByPriority() {

    }

    @Test
    public void getPostByLastEditTime() {

    }


}
