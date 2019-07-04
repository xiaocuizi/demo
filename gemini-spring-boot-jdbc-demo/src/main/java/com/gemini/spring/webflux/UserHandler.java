package com.gemini.spring.webflux;

import com.gemini.spring.domain.User;
import com.gemini.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.webflux
 * @classname: UserHandler
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/22 10:35
 */
@Component
public class UserHandler {

    private final UserRepository userRepository;


    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        Mono<Boolean> booleanMono = userMono.map(userRepository::saveUser);
        return ServerResponse.ok().body(booleanMono, Boolean.class);
    }
}
