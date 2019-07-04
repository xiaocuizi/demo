package com.gemini.spring.geminimicroservicesproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GeminiMicroservicesProjectApplication {

    public static void main(String[] args) {
        //SpringApplication.run(GeminiMicroservicesProjectApplication.class, args);
        /*new SpringApplicationBuilder(GeminiMicroservicesProjectApplication.class)
                .properties("server.port=8888").run(args);*/
        new SpringApplicationBuilder(GeminiMicroservicesProjectApplication.class)
                .properties("server.port=8080").run(args);
    }

}

