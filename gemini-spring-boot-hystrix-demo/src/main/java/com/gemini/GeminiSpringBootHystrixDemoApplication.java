package com.gemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

@SpringBootApplication
@EnableCircuitBreaker
@EnableTurbine
@PropertySource(value = {"a.properties"})
public class GeminiSpringBootHystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringBootHystrixDemoApplication.class, args);
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		InputStream resourceAsStream = contextClassLoader.getResourceAsStream("a.properties");
		Properties properties= new Properties();
		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Properties properties = System.getProperties();
		System.out.println(properties.getProperty("my.name")+"=====================>");
	}

}
