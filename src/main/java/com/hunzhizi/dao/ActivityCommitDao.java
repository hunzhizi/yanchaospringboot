package com.hunzhizi.dao;

import com.hunzhizi.domain.ActivityCommit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 18:26
 * @description:
 */
@Transactional
@Mapper
public interface ActivityCommitDao {
    //提交信息
    boolean createCommit(ActivityCommit commit);

    //取消活动
    boolean deleteCommitByUserIdNActivityId(@Param("userId") Integer userId, @Param("activityId") Integer activityId);

    //根据用户id和活动id进行查找
    ActivityCommit getCommitByUserIdNActivityId(@Param("userId") Integer userId, @Param("activityId") Integer activityId);
//    //返回该活动所有提交
//    boolean getCommitsByActivityId(Integer activityId);

}
