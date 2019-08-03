package com.gemini.pattern.proxy.pay;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.pattern.proxy.pay
 * @classname: PayProxy
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/7 16:21
 */
public class PayProxy implements Payment {

    Payment payment = new ThirdPay();
    PayLogger payLogger = new PayLogger();

    @Override
    public String doPay(String uid) {
        payLogger.log(uid);
        return payment.doPay(uid);
    }
}


