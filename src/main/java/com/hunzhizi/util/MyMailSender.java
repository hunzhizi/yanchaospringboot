package com.hunzhizi.util;

import com.hunzhizi.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author 魂之子
 * @since 2022-10-03 10:29
 * program: yanchaospringboot
 * description: 该类用于处理邮件的发送相关操作
 */
@Component
public class MyMailSender {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendMail(Activity activity, File file) throws MessagingException {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject(activity.getTitle()+"收集人员信息");
        helper.setFrom("1542106578@qq.com");
        helper.setTo(activity.getSubmitEmail());
        helper.setSentDate(new Date());        //设置邮件的发送日期
        helper.setText(activity.getActivityDesc()+ "\n活动收集的人员信息见附件");
        helper.addAttachment(activity.getTitle() + ".xlsx", file);
        javaMailSender.send(mimeMessage);
        file.delete();
    }

}
