package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.ZhiHuQuestionDao;
import com.hunzhizi.domain.Post;
import com.hunzhizi.domain.ZhiHuQuestion;
import com.hunzhizi.service.ZhiHuQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 17:02
 * @description:
 */
@Service
public class ZhiHuQuestionImpl implements ZhiHuQuestionService {

    @Resource
    private ZhiHuQuestionDao zhiHuQuestionDao;

    @Override
    public PageInfo<ZhiHuQuestion> getQuestionsByPriority(Integer pageNum, Integer pageSize) {
        List<ZhiHuQuestion> questions = zhiHuQuestionDao.getQuestionsByPriority();
        PageHelper.startPage(pageNum, pageSize);
        //下面要进行热度更新
        for (ZhiHuQuestion zhiHuQuestion : questions) {
            //如果帖子的举报数量超过10 ，就将其delete掉
            if (zhiHuQuestion.getReportNum() != null && zhiHuQuestion.getReportNum() >= 10) {
                zhiHuQuestionDao.delQuestionById(zhiHuQuestion.getZhiHuQuestionId());
                continue;
            }
            zhiHuQuestion.setPriority();
            zhiHuQuestionDao.updateQuestion(zhiHuQuestion);
        }

        return new PageInfo<>(questions);
    }

    @Override
    public PageInfo<ZhiHuQuestion> getQuestionsByRand(Integer pageNum, Integer pageSize) {
        List<ZhiHuQuestion> questions = zhiHuQuestionDao.getQuestionsByPriority();
        Collections.shuffle(questions);
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(questions);
    }

    @Override
    public PageInfo<ZhiHuQuestion> getQuestionsByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        List<ZhiHuQuestion> questions = zhiHuQuestionDao.getQuestionsByUserId(userId);
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(questions);
    }

    @Override
    public boolean createQuestion(ZhiHuQuestion question) {
        return zhiHuQuestionDao.createQuestion(question);
    }

    @Override
    public boolean delQuestionById(Integer questionId) {
        return zhiHuQuestionDao.delQuestionById(questionId);
    }

    @Override
    public boolean updateQuestion(ZhiHuQuestion question) {
        if (question.getReportNum() != null && question.getReportNum() >= 5) {
            return zhiHuQuestionDao.delQuestionById(question.getZhiHuQuestionId());
        }
        question.setLastEditTime(new Date());
        return zhiHuQuestionDao.updateQuestion(question);
        //应该更新一下priority
    }
}
