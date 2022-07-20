package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.ActivityDao;
import com.hunzhizi.domain.Activity;
import com.hunzhizi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 16:14
 * @description:
 */
@Service
public class ActivityImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public boolean createActivity(Activity activity) {
        return activityDao.createActivity(activity);
    }

    @Override
    public boolean updateActivity(Activity activity) {
        return activityDao.updateActivity(activity);
    }

    @Override
    public Activity getActivityById(Integer activityId) {
        return activityDao.getActivityById(activityId);
    }

    @Override
    public PageInfo<Activity> getAllActivity(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Activity> allActivity = activityDao.getAllActivity();
        return new PageInfo<>(allActivity);
    }
}
