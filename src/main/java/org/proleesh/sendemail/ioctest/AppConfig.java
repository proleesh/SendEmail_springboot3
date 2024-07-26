package org.proleesh.sendemail.ioctest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name="user")
    public User initUser(){
        var user = new User();
        user.setId(1L);
        user.setUsername("Proleesh");
        user.setNote("Hello world");
        return user;
    }
}
