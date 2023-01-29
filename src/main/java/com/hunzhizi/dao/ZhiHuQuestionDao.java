package com.hunzhizi.dao;

import com.hunzhizi.domain.ZhiHuQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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

    @Update("update post set report_num = report_num +1 " +
            "where zhi_hu_question_id = #{zhiHuQuestionId}")
    boolean plusQuestionNum(@Param("zhiHuQuestionId") Integer zhiHuQuestionId);

    boolean delQuestionById(Integer questionId);

    boolean updateQuestion(ZhiHuQuestion question);

    //根据关键词查询

    List<ZhiHuQuestion> getQuestionsByUserId(Integer userId);
}
