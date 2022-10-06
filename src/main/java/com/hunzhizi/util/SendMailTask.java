package com.hunzhizi.util;

import com.hunzhizi.dao.ActivityCommitDao;
import com.hunzhizi.dao.ActivityDao;
import com.hunzhizi.domain.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

/**
 * @author 魂之子
 * @since 2022-10-03 18:08
 * program: yanchaospringboot
 * description: 该类是一个定时任务用于进行邮件发送的定时任务的编写
 */
@Component
public class SendMailTask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private int i;

    @Resource
    ActivityDao activityDao;
    @Resource
    ActivityCommitDao activityCommitDao;
    @Resource
    MyMailSender sender;
    @Scheduled(cron = "0 0 1 * * ?")    //每天1点触发一次
    public void execute() {
        logger.info("thread id:{},FixedPrintTask execute times:{}", Thread.currentThread().getId(), ++i);
        //查询所有到时间的定时任务，并将到时的任务进行邮件的发送
        List<Activity> activityByDate = activityDao.getActivityByDate();
        for (Activity activity : activityByDate) {
            String filePathName = ExcelUtil.convert2Excel(activity, activityCommitDao.getCommitsByActivityId(activity.getActivityId()));
            try {
                sender.sendMail(activity,new File(filePathName));
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
