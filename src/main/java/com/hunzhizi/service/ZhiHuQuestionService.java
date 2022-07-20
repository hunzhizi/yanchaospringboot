package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.ZhiHuQuestion;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 17:01
 * @description:
 */
@Transactional
public interface ZhiHuQuestionService {
    PageInfo<ZhiHuQuestion> getQuestionsByPriority(Integer pageNum, Integer pageSize);

    PageInfo<ZhiHuQuestion> getQuestionsByRand(Integer pageNum, Integer pageSize);

    boolean createQuestion(ZhiHuQuestion question);

    boolean delQuestionById(Integer questionId);

    boolean updateQuestion(ZhiHuQuestion question);
}
