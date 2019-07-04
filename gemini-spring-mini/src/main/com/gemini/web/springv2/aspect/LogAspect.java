package com.gemini.web.springv2.aspect;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.web.springv2.aspect
 * @classname: LogAspect
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/23 11:55
 */
public class LogAspect {


    /**
     * 方法之前调用
     */
    public void before(){
        System.out.println("LogAspect:invoke before...............");
    }

    /**
     * 在调用一个方法之后处理逻辑
     */
    public void after(){
        System.out.println("LogAspect:exe after...............");
    }
}
