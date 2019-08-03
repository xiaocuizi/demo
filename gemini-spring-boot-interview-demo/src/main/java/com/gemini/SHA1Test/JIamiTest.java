package com.gemini.SHA1Test;
import org.apache.commons.lang3.StringUtils;
 import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.SHA1Test
 * @classname: JIamiTest
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/7/12 10:40
 */
public class JIamiTest {


    /**
     * @Comment SHA1加密密码
     * @Author Ron
     * @Date 2017年9月12日 下午2:46:31
     * @return
     */
    public static String encodePassword(String psw) {
        if(StringUtils.isEmpty(psw)){
            return null;
        }else{
            return DigestUtils.sha1Hex(psw);
        }
    }

}


