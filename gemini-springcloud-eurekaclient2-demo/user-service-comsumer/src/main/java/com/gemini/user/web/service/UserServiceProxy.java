package com.gemini.user.web.service;

import com.gemini.user.domain.User;
import com.gemini.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.user.web.service
 * @classname: UserServiceProxy
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/23 18:37
 */
@Service
public class UserServiceProxy implements UserService {

    private static  final String PROVIDER_SERVER_URL_PREFIX ="http://gemini-user-service-provider" ;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 成功tr
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        try {
            User user1 = restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save", user, User.class);
            return user1 == null ? false : true;
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 不会返回NULL
     *
     * @return
     */
    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", Collection.class);
    }
}
