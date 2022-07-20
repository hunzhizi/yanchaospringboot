package com.hunzhizi.dao;

import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @since 2022-05-31 12:50
 * program: yanchaospringboot
 * description:
 */
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
public class MyCollectionDaoTest {
    @Resource
    MyCollectionDao dao;
    @Test
    public void insert(){
        dao.insert(1,9);
    }

    @Test
    public void get(){
        List<Post> collectionsByUser = dao.getCollectionsByUser(1);
        Post post = collectionsByUser.get(0);
        System.out.println(post);
    }
}
