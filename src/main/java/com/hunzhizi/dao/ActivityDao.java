package com.hunzhizi.dao;

import com.hunzhizi.domain.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 15:40
 * @description:
 */
@Mapper
public interface ActivityDao {
    //创建活动
    boolean createActivity(Activity activity);

    //修改活动
    boolean updateActivity(Activity activity);

    //获取活动信息byId
    Activity getActivityById(Integer activityId);

    List<Activity> getAllActivity();

    //将参与人数++
    void plusParticipateNum(Integer activityId);

    //将参与人数--
    void minusParticipateNum(Integer activityId);

}
