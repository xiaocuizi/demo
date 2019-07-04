package com.gemini.geminispringboothystrixturbinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class GeminiSpringBootHystrixTurbineDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringBootHystrixTurbineDemoApplication.class, args);
	}

}
