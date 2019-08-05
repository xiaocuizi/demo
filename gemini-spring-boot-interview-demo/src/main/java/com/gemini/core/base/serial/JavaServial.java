package com.gemini.core.base.serial;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @Package com.gemini.test.core.base.serial
 * @classname: JavaServial
 * @Description: todo (用一句话描述该文件做什么)
 * @date 2019/4/10 16:49
 */
public interface JavaServial {

    byte[] serial(Object o);

    Object unDerial(byte[] o);

}


