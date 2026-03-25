package com.sathya.rest.EmailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sathya.rest.EmailService.EmailService;
import com.sathya.rest.model.EmailRequest;
import com.sathya.rest.model.EmailResponse;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public EmailResponse sendEmail(@RequestBody EmailRequest request) {

        return emailService.sendEmail(request);
    }
}