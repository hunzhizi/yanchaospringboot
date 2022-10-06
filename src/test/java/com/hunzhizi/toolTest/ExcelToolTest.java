package com.hunzhizi.toolTest;

import com.hunzhizi.YanchaoSpringbootApplication;
import com.hunzhizi.domain.Activity;
import com.hunzhizi.domain.ActivityCommit;
import com.hunzhizi.util.ExcelUtil;
import com.hunzhizi.util.MyMailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 魂之子
 * @since 2022-10-03 13:54
 * program: yanchaospringboot
 * description:
 */
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class ExcelToolTest {
    @Autowired
    MyMailSender mailSender;
    @Test
    public void testExcelSend() throws MessagingException {

        ArrayList<ActivityCommit> activityCommits = new ArrayList<>();
        ActivityCommit activityCommit = new ActivityCommit();
        activityCommit.setStuId("201911040113");
        activityCommit.setQq("290249675");
        activityCommit.setPhoneNum("13179290325");
        activityCommit.setClazz(4);
        activityCommits.add(activityCommit);
        Activity activity = new Activity();
        activity.setTitle("蓝桥杯");
        activity.setSubmitEmail("290249675@qq.com");
        activity.setActivityDesc("desc on activity");
        String s = ExcelUtil.convert2Excel(activity, activityCommits);
        System.out.println(s);
        mailSender.sendMail(activity,new File(s));
    }

    @Test
    public void testSend() throws MessagingException {
        Activity activity = new Activity();
        activity.setTitle("蓝桥杯");
        activity.setSubmitEmail("290249675@qq.com");
        activity.setActivityDesc("desc on activity");
        mailSender.sendMail(activity,new File("D:\\蓝桥杯2022-10-03.xlsx"));
    }
}
