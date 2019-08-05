package com.gemini.core.proxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.proxy
 * @classname: Test
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 9:56
 */
public class Test {
    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"code");
        CglibDynamicProxy cglibDynamicProxy= new CglibDynamicProxy();
        ThirdChannelPayment proxyInstance = (ThirdChannelPayment)cglibDynamicProxy.getInstance(new ThirdChannelPayment());

        System.out.println(proxyInstance.pay("mic"));
    }
}


