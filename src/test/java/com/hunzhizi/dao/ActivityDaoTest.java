package com.hunzhizi.dao;


import com.hunzhizi.domain.Activity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 15:57
 * @description:
 */
@SpringBootTest
public class ActivityDaoTest {
    @Autowired
    ActivityDao activityDao;

    @Test
    public void createActivity() {
        Activity activity = new Activity();
        activity.setActivityDesc("蓝桥杯比赛报名,希望大家参加2");
        activity.setTitle("蓝桥杯比赛报名");
        activity.setSubmitEmail("290249675@qq.com");
        activity.setUserId(2);
        activity.setDeadline(new Date());
        activityDao.createActivity(activity);
    }

    @Test
    public void updateActivity() {
        Activity activity = new Activity();
        activity.setActivityDesc("大家不要参加啊");
        activity.setActivityId(1);
        activityDao.updateActivity(activity);
    }

    @Test
    public void getActivityById() {
        Activity activityById = activityDao.getActivityById(1);
        System.out.println(activityById.getActivityDesc());
    }


}
