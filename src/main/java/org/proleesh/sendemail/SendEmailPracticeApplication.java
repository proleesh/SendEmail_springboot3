package org.proleesh.sendemail;

import lombok.extern.slf4j.Slf4j;
import org.proleesh.sendemail.service.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SendEmailPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendEmailPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TestService testService) {
        return args -> {
            log.info(testService.getServiceName());
        };
    }
}
