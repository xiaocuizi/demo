package com.gemini.spring.webflux;

import com.gemini.spring.repository.UserRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.webflux
 * @classname: WebFluxConfiguration
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/21 21:22
 */
@Configuration
public class WebFluxConfiguration {


    /**
     *
     * @param userRepository
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler userRepository){
        return route(POST("/web/flux/user/save"),userRepository::saveUser);
    }
}
