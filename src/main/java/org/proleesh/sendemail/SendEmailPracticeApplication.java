package org.proleesh.sendemail;

import lombok.extern.slf4j.Slf4j;
import org.proleesh.sendemail.exception.JavaStackException;
import org.proleesh.sendemail.service.TestService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SendEmailPracticeApplication {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(SendEmailPracticeApplication.class);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.run(args);
//        SpringApplication.run(SendEmailPracticeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TestService testService) {
        return args -> {
            log.info(testService.getServiceName());
        };
    }

//    @Bean
//    public CommandLineRunner commandLineRunner2(){
//        return args -> {
//            throw new JavaStackException("Java Stack Exception");
//        };
//    }
}
