package com.gemini.pattern.lazy;

/**
 * @author xiaocuzi
 * @package com.gemini.pattern.lazy
 * @classname: EnumSigleTon
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/5/15 15:22
 * @since 1.0.0
 */
public enum EnumSigleTon {

    INSTANCE;

    private Object data;

    EnumSigleTon(){
        data =  new Object();
    }

    public Object getInstance(){
        return this.data;
    }
}
