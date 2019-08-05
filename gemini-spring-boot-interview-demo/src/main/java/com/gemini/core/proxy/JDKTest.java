package com.gemini.core.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.proxy
 * @classname: JDKTest
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/8 10:08
 */
public class JDKTest {
    public static void main(String[] args) throws FileNotFoundException {
        JdkDynamicProx jdkDynamicProx = new JdkDynamicProx();
        Payment payment3= new ThirdChannelPayment();
        Payment payment = (Payment) jdkDynamicProx.bind(payment3);
        System.out.println(payment.pay("mic"));

        byte[] $proxy0s = ProxyGenerator.generateProxyClass("$proxy0", payment3.getClass().getInterfaces());
        String path =  "PaymentProxy.class";
        try (FileOutputStream fos = new FileOutputStream(path)){
            fos.write($proxy0s);
            fos.flush();
            System.out.println("end..");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


