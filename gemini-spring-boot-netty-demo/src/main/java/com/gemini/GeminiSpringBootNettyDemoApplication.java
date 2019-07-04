package com.gemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class GeminiSpringBootNettyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringBootNettyDemoApplication.class, args);
	}
}
