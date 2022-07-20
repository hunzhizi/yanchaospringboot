package com.hunzhizi.dao;

import com.hunzhizi.domain.ZhiHuQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 16:38
 * @description:
 */
@Mapper
public interface ZhiHuQuestionDao {
    List<ZhiHuQuestion> getQuestionsByPriority();

    boolean createQuestion(ZhiHuQuestion question);

    boolean delQuestionById(Integer questionId);

    boolean updateQuestion(ZhiHuQuestion question);

    //根据关键词查询

}
