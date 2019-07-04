package com.gemini.spring.service;

import com.gemini.spring.annotation.TransationalService;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.service
 * @classname: UserService
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/18 17:01
 */
@TransationalService(value="echoService")
public class EchoService {
    /**
     *
     * @param msg
     * @return
     */
    public String say(String msg){
        System.out.println("msg="+msg);
        return msg;
    }
}
