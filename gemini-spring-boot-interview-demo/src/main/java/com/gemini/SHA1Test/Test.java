package com.gemini.SHA1Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.SHA1Test
 * @classname: Test
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/7/12 11:05
 */
public class Test {

    public static void main(String[] args) {
        String encode = encode("{\"eventMs\":1560408533119,\"eventType\":10,\"noticeId\":\"4eb720f0-8da7-11e9- e-53f411c2761f\",\"notifyMs\":1560408533119,\"payload\":{\"a\":\"1\",\"b\":2},\"productId\":1}", "secret");
        System.out.println(encode);
        if(encode.equals("b5ef4206b0d7c378a88193d1cbeea093255bc5f4")){
            System.out.println("匹配成功....");
        }
    }

    public static String encode(String data, String key) {
        try {
            return hamcsha1(data.getBytes("UTF-8"), key.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String hamcsha1(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return byte2hex(mac.doFinal(data));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    //二行制转字符串
    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
       // return hs.toString().toUpperCase();
        return hs.toString().toLowerCase();
    }
}


