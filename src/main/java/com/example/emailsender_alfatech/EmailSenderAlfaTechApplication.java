package com.example.emailsender_alfatech;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EmailSenderAlfaTechApplication implements CommandLineRunner {

    @Autowired
    Email email;

    public static void main(String[] args) {
        SpringApplication.run(EmailSenderAlfaTechApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending email...");
        email.sendEmail("kossomega42@gmail.com", "Test email", "Test email body");
        log.info("Email was sent");
        log.info("Done");
    }

    //    @EventListener(ApplicationReadyEvent.class) //this is another way to send email
//    public void sendEmail() {
//        log.info("Sending email...");
//        email.sendEmail();
////        try {
////            log.info("Sending email with attachment...");
////            email.sendEmailWithAttachment();
////        } catch (MessagingException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        log.info("Done");
//    }
}
