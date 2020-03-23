package com.gemini.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gemini.shop.service.IUerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.service
 * @classname: UserServiceImpl
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2020/3/23 10:42
 */
@Component
@Service(interfaceClass = IUerInterface.class) // dubbo的Service
public class UserServiceImpl implements IUerInterface {
    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String sayHello(String name) {
        log.info("sayHello:access success...........name={}", name);
        return "hello:" + name;
    }
}


