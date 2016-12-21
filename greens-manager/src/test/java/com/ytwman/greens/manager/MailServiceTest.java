package com.ytwman.greens.manager;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

/**
 * Created by ytwman on 16/12/21.
 */
public class MailServiceTest extends BaseTest {

    @Resource
    JavaMailSenderImpl javaMailSender;

    @Test
    public void testSendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("huhu@xiaokakeji.com");
        simpleMailMessage.setFrom("broker_0710@126.com");
        simpleMailMessage.setSubject("测试邮件");
        simpleMailMessage.setText("测试邮件内容!!!");

        javaMailSender.send(simpleMailMessage);
    }
}
