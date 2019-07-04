package com.gemini.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author xiaocuzi
 * @package com.gemini.redis
 * @classname: RedisController
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/3/8 17:04
 * @since 1.0.0
 */
@RestController
public class RedisController {
    /*@Autowired
    private StringRedisTemplate stringRedisTemplate;*/
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/set")
    public String index(){
        try {
            stringRedisTemplate.opsForValue().set("key1","hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "yes";
    }

    @GetMapping("/get")
    public String get(){
        return String.valueOf(stringRedisTemplate.opsForValue().get("key1"));
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.81.130", 6379);
        jedis.set("java", "http://www.baidu.com");
        String value = jedis.get("java");
        System.out.println(value);
    }
}
