package com.mary.tasktracker_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ivykibali@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Welcome to Task Tracker!");
        message.setText(
            "Hi " + name + ",\n\n" +
            "Your Task Tracker account has been created successfully!\n\n" +
            "You can now log in and start managing your tasks.\n\n" +
            "Best regards,\n" +
            "Task Tracker Team"
        );
        mailSender.send(message);
    }
}