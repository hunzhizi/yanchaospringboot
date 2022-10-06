package com.hunzhizi.toolTest;

import com.hunzhizi.YanchaoSpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author 魂之子
 * @since 2022-10-02 19:52
 * program: yanchaospringboot
 * description:
 */
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class MyMailSenderTest {
    @Autowired
    JavaMailSender javaMailSender;
    @Test
    public void sendMailTest(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("1542106578@qq.com");
        message.setTo("290249675@qq.com");
//        message.setCc("37xxxxx37@qq.com");    //设置抄送人
//        message.setBcc("14xxxxx098@qq.com");  //设置隐秘抄送人
        message.setSentDate(new Date());        //设置邮件的发送日期
        message.setText("这是测试邮件的正文");
        javaMailSender.send(message);
    }

    @Test
    public void sendMailTest2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("1542106578@qq.com");
        helper.setTo("290249675@qq.com");
        helper.setSentDate(new Date());        //设置邮件的发送日期
        helper.setText("这是测试邮件的正文"+ "\n活动收集的人员信息见附件");
        helper.addAttachment("附件测试.jpg", new File("E:\\燕巢\\燕宝.jpg"));
        javaMailSender.send(mimeMessage);
    }

}
