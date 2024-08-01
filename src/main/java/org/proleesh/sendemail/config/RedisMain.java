package org.proleesh.sendemail.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisMain {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
        try{
            var redisTemplate = ctx.getBean(RedisTemplate.class);
            redisTemplate.opsForValue().set("key1", "value1");
            redisTemplate.opsForHash().put("hash", "field",
                    "hvalue");
        }finally{
            ctx.close();
        }
    }
}
