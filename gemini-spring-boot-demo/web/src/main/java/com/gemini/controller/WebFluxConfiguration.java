package com.gemini.controller;

import com.gemini.entiy.User;
import com.gemini.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.geminispringbootdemo.controller
 * @classname: WebFluxConfiguration
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/17 17:49
 */
@Configuration
public class WebFluxConfiguration {


    /**
     * @param userRepository
     * @return
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> responseRourterFunction(UserRepository userRepository) {
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
        return RouterFunctions.route(RequestPredicates.path("/users"),
                serverRequest -> ServerResponse.ok().body(userFlux, User.class));

    }
}
