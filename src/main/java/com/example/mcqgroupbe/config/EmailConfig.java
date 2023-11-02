package com.example.mcqgroupbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); 
        mailSender.setPort(587); 
        mailSender.setUsername("arik.bhar9999@gmail.com"); 
        mailSender.setPassword("arik.bhar99"); 

        return mailSender;
    }
}