package com.hunzhizi.dao;

import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.PostImg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2022-06-03 20:14
 * program: yanchaospringboot
 * description:
 */
@RunWith(SpringRunner.class)
//一定要注意当手动指定springBootTest的时候，也要手动指定RunWith的类
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
public class PostImgDaoTest {
    @Resource
    private PostImgDao postImgDao;
    @Test
    public void insert(){
        PostImg postImg = new PostImg();
        postImg.setImgName("hunzhizi");
        postImg.setPostId(1);
        boolean insert = postImgDao.insert(postImg);
    }
    @Test
    public void del(){

        boolean insert = postImgDao.deleteByPostId(1);
    }
    @Test
    public void select(){
       postImgDao.selectByPostId(1);
    }
}
