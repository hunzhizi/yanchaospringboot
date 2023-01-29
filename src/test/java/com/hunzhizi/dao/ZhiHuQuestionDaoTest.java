package com.hunzhizi.dao;


import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.ZhiHuQuestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 16:52
 * @description:
 */
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class ZhiHuQuestionDaoTest  {
    @Autowired
    private ZhiHuQuestionDao zhiHuQuestionDao;

    @Test
    public void getQuestionsByPriority() {

    }

    @Test
    public void getQuestionsByUserId(){
        List<ZhiHuQuestion> list = zhiHuQuestionDao.getQuestionsByUserId(2);
        for (ZhiHuQuestion question:
             list) {
            System.out.println(question.getQuestionContent());
        }
    }
    @Test
    public void createQuestion() {
        ZhiHuQuestion zhiHuQuestion = new ZhiHuQuestion();
        zhiHuQuestion.setUserId(1);
        zhiHuQuestion.setQuestionContent("欢迎大家来到燕巢的校园知乎，有什么问题尽管提问");
        zhiHuQuestionDao.createQuestion(zhiHuQuestion);
    }

    @Test
    public void delQuestionById() {

    }

    @Test
    public void updateQuestion() {
        ZhiHuQuestion zhiHuQuestion = new ZhiHuQuestion();
        zhiHuQuestion.setZhiHuQuestionId(1);
        zhiHuQuestion.setQuestionContent("欢迎大家来到燕巢的校园知乎，有什么问题尽管提问");
        zhiHuQuestionDao.updateQuestion(zhiHuQuestion);
    }

}
