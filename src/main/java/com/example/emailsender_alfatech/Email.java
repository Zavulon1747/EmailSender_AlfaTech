package com.example.emailsender_alfatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class Email {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String sentTo, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("riddick40.000@gmail.com");
        message.setTo(sentTo);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setFrom("riddick40.000@gmail.com");
        helper.setTo("kossomega42@gmail.com.com");
        helper.setSubject("Test from Spring Boot");
        helper.setText("<h1>This is a test</h1>", true);
        helper.addAttachment("meme.jpg", new ClassPathResource("D:\\Work\\demo\\AlfaTech_NotificationSender\\src\\main\\resources\\imageToAttachment\\meme.jpg"));

        javaMailSender.send(msg);
    }
}
