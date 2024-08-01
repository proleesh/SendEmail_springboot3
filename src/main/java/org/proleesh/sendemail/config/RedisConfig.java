package org.proleesh.sendemail.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
public class RedisConfig {
    // create redis factory
    @Bean(name="RedisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {
        // Redis configuration
        var redisCfg = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        // Password setting
        redisCfg.setPassword("proleesh");
        // Connection pool configuration
        var poolConfig = new GenericObjectPoolConfig<Object>();
        // Maximum active
        poolConfig.setMaxIdle(30);
        // Maximum connected
        poolConfig.setMaxTotal(50);
        // Client configuration about Lettuce connection pool, construction mode in there
        var lettuceCfg = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(2))
                .poolConfig(poolConfig)
                .build();
        var connectionFactory = new LettuceConnectionFactory(redisCfg, lettuceCfg);
        return connectionFactory;
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(@Autowired RedisConnectionFactory factory, LettuceConnectionFactory redisConnectionFactory) {
        var redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
