package com.gemini.core.proxy;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.proxy
 * @classname: ThirdChannelPayment
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 9:55
 */
public class ThirdChannelPayment implements Payment {

    @Override
    public String pay(String uid) {
        System.out.println(uid + "正在执行第三方支付》。。。");
        return "success";
    }
}


