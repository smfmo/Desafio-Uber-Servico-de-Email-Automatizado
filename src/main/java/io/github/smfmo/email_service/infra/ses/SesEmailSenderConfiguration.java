package io.github.smfmo.email_service.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SesEmailSenderConfiguration {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        return null;
    }
}
