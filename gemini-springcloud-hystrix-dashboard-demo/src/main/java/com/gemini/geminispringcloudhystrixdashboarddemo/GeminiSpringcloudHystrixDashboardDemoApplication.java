package com.gemini.geminispringcloudhystrixdashboarddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableHystrixDashboard
@PropertySource(value = {"a.properties"})
public class GeminiSpringcloudHystrixDashboardDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringcloudHystrixDashboardDemoApplication.class, args);
	}

}
