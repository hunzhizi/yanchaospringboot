package com.hunzhizi.dao;

import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.WechatAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2022-08-26 13:38
 * program: yanchaospringboot
 * description:
 */
@RunWith(SpringRunner.class)
//一定要注意当手动指定springBootTest的时候，也要手动指定RunWith的类
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
public class WechatAuthDaoTest {
    @Resource
    WechatAuthDao dao;
    @Test
    public void testSelect(){
        WechatAuth wechatAuthByOpenId = dao.getWechatAuthByOpenId("0");
        System.out.println(wechatAuthByOpenId.getOpenId());
    }

    @Test
    public void testInsert(){
        WechatAuth wechatAuth = new WechatAuth();
        wechatAuth.setOpenId("test1");
        wechatAuth.setUserId(2);
        dao.insert(wechatAuth);
    }
}
