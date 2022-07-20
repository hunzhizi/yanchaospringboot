package com.hunzhizi.service.impl;

import com.hunzhizi.dao.ActivityCommitDao;
import com.hunzhizi.dao.ActivityDao;
import com.hunzhizi.domain.ActivityCommit;
import com.hunzhizi.service.ActivityCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 18:55
 * @description:
 */
@Service
public class ActivityCommitServiceImpl implements ActivityCommitService {

    @Autowired
    private ActivityCommitDao commitDao;
    @Autowired
    private ActivityDao activityDao;

    @Override
    public boolean createCommit(ActivityCommit commit) {
        activityDao.plusParticipateNum(commit.getActivityId());
        return commitDao.createCommit(commit);
    }

    //实际上可以使用activity_commit_id 进行删除
    @Override
    public boolean deleteCommitByUserIdNActivityId(Integer userId, Integer activityId) {
        activityDao.minusParticipateNum(activityId);
        return commitDao.deleteCommitByUserIdNActivityId(userId, activityId);
    }

    @Override
    public ActivityCommit getCommitByUserIdNActivityId(Integer userId, Integer activityId) {
        return commitDao.getCommitByUserIdNActivityId(userId, activityId);
    }


}
