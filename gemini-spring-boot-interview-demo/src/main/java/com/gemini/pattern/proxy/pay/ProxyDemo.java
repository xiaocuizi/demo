package com.gemini.pattern.proxy.pay;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.pattern.proxy.pay
 * @classname: ProxyDemo
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/7 16:19
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Payment payment = new PayProxy();
        payment.doPay("3434");
    }
}


