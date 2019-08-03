package com.gemini.pattern.proxy.pay;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.pattern.proxy.pay
 * @classname: ThirdPay
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/7 16:18
 */
public class ThirdPay implements Payment {
    @Override
    public String doPay(String uid) {
        System.out.println("我是第三方支付。。。。");
        return "success";
    }
}


