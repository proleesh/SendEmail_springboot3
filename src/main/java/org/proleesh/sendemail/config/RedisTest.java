package org.proleesh.sendemail.config;

import io.lettuce.core.api.async.RedisAsyncCommands;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class RedisTest {
    private final RedisTemplate redisTemplate = null;

    private final StringRedisTemplate stringRedisTemplate = null;

    @PostConstruct
    public void testRedis(){

    }

    private void testStringAndHash(){
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int",1);

        var commands = (RedisAsyncCommands)stringRedisTemplate.getConnectionFactory()
                .getConnection().getNativeConnection();
        commands.decr("int");
        commands.quit();
        var hash = new HashMap<String, String>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");

        stringRedisTemplate.opsForHash().putAll("hash", hash);
        stringRedisTemplate.opsForHash().put("hash", "field3",
                "value3");
        var hashOps = stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1", "field2");
        hashOps.put("field4", "value4");
    }
    private void testList(){
        stringRedisTemplate.opsForList().
                leftPushAll("list1", "v2", "v4",
                        "v6", "v8", "v10");
        stringRedisTemplate.opsForList().rightPushAll(
                "list2", "v1", "v2",
                "v3", "v4", "v5", "v6"
        );
        var listOps = stringRedisTemplate.boundListOps("list2");
        var result1 = listOps.rightPop();
        var result2 = listOps.index(1);
        listOps.leftPush("v0");
        var size = listOps.size();
        var element = listOps.range(0, size-2);
    }

    private void testSet(){
        stringRedisTemplate.opsForSet().add("set1", "v1",
                "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForSet().add("set2", "v2",
                "v4", "v6", "v8");
        var setOps = stringRedisTemplate.boundSetOps("set1");
        setOps.add("v6", "v7");
        setOps.remove("v1", "v7");
        var set1 = setOps.members();
        Long size = setOps.size();
        var inter = setOps.intersect("set2");
        setOps.intersectAndStore("set2", "inter");
        var diff = setOps.difference("set2");
        setOps.differenceAndStore("set2", "diff");
        var union = setOps.union("set2");
        setOps.unionAndStore("set2", "union");

    }

    public static void main(String[] args) {
        RedisTest test = new RedisTest();
        test.testRedis();
        test.testSet();
        test.testList();
    }

}
