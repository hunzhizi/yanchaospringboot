package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 16:09
 * @description:
 */
@Transactional
public interface ActivityService {
    //创建活动
    boolean createActivity(Activity activity);

    //修改活动
    boolean updateActivity(Activity activity);

    //获取活动信息byId
    Activity getActivityById(Integer activityId);

    PageInfo<Activity> getAllActivity(Integer pageNum, Integer pageSize);

    PageInfo<Activity> getActivityByUserId(Integer pageNum,Integer pageSize,Integer userId);
}
