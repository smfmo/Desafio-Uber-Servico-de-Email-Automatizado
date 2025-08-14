package io.github.smfmo.email_service.controllers;

import io.github.smfmo.email_service.application.EmailSenderService;
import io.github.smfmo.email_service.core.EmailRequest;
import io.github.smfmo.email_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try{
            this.emailSenderService.sendEmail(
                    request.to(), request.subject(), request.body());
            return ResponseEntity.ok("email sent successfully");

        } catch (EmailServiceException exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while sending email");
        }
    }

}
