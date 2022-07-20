package com.hunzhizi.service;

import com.hunzhizi.domain.ActivityCommit;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 18:54
 * @description:
 */
@Transactional
public interface ActivityCommitService {
    //提交信息
    boolean createCommit(ActivityCommit commit);

    //取消活动
    boolean deleteCommitByUserIdNActivityId(Integer userId, Integer activityId);

    //根据用户id进行查找
    ActivityCommit getCommitByUserIdNActivityId(Integer userId, Integer activityId);
}

