package com.sathya.rest.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sathya.rest.model.EmailRequest;
import com.sathya.rest.model.EmailResponse;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.from}")
    private String senderMail;

    public EmailResponse sendEmail(EmailRequest emailRequest) {

        EmailResponse response = new EmailResponse();

        try {

            // Create Mail Message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(senderMail);
            mailMessage.setTo(emailRequest.getReceiverMail());
            mailMessage.setSubject(emailRequest.getSubject());
            mailMessage.setText(emailRequest.getBody());

            // Send Email
            mailSender.send(mailMessage);

            // Success Response
            response.setReceiverMail(emailRequest.getReceiverMail());
            response.setSenderMail(senderMail);
            response.setStatus("SUCCESS");
            response.setMessage("Email sent successfully");

        } catch (Exception ex) {
            // Failure Response
            response.setStatus("FAILED");
            response.setMessage("Error while sending email: " + ex.getMessage());
        }

        return response;
    }
}