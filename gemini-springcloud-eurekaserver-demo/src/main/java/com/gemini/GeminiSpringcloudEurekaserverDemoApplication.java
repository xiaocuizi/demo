package com.gemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GeminiSpringcloudEurekaserverDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringcloudEurekaserverDemoApplication.class, args);
	}

}
