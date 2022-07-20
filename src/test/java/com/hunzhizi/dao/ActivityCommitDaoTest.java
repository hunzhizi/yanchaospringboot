package com.hunzhizi.dao;

import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.ActivityCommit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 18:46
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
public class ActivityCommitDaoTest {
    @Autowired
    private ActivityCommitDao activityCommitDao;

    @Test
    public void createCommit() {
        ActivityCommit activityCommit = new ActivityCommit();
        activityCommit.setUserId(1);
        activityCommit.setActivityId(1);
        activityCommit.setStuName("魂之子");
        activityCommit.setClazz(4);
        activityCommit.setPhoneNum("13180961888");
        activityCommit.setQq("290249675");
        activityCommit.setStuId("201911040113");
        activityCommitDao.createCommit(activityCommit);
    }

    @Test
    public void deleteCommitByUserIdNActivityId() {
        activityCommitDao.deleteCommitByUserIdNActivityId(2, 3);
    }

    @Test
    public void getCommitByUserId() {
        //todo 当一个人有多个提交的时候，该操作会出现异常
        activityCommitDao.getCommitByUserIdNActivityId(1,1);
    }
}
