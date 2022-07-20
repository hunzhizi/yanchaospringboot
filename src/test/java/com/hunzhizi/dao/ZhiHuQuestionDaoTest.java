package com.hunzhizi.dao;


import com.hunzhizi.domain.ZhiHuQuestion;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 16:52
 * @description:
 */
@SpringBootTest
public class ZhiHuQuestionDaoTest  {
    @Autowired
    private ZhiHuQuestionDao dao;

    @Test
    public void getQuestionsByPriority() {

    }

    @Test
    public void createQuestion() {
        ZhiHuQuestion zhiHuQuestion = new ZhiHuQuestion();
        zhiHuQuestion.setUserId(1);
        zhiHuQuestion.setQuestionContent("欢迎大家来到燕巢的校园知乎，有什么问题尽管提问");
        dao.createQuestion(zhiHuQuestion);
    }

    @Test
    public void delQuestionById() {

    }

    @Test
    public void updateQuestion() {
        ZhiHuQuestion zhiHuQuestion = new ZhiHuQuestion();
        zhiHuQuestion.setZhiHuQuestionId(1);
        zhiHuQuestion.setQuestionContent("欢迎大家来到燕巢的校园知乎，有什么问题尽管提问hhh");
        dao.updateQuestion(zhiHuQuestion);
    }

}
