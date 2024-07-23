package org.proleesh.sendemail.config;

import org.proleesh.sendemail.service.TestService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
@AutoConfiguration
@ConditionalOnProperty(prefix="org.proleesh.sendemail", name="enabled", havingValue = "true")
public class TestServiceAutoConfiguration {
    @Bean
    public TestService testService() {
        return new TestService();
    }
}
