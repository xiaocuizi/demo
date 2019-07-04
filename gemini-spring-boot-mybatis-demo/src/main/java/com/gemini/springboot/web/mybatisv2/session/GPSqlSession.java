package com.gemini.springboot.web.mybatisv2.session;

import com.gemini.springboot.web.mybatisv2.configuration.GPConfiguration;
import com.gemini.springboot.web.mybatisv2.executor.GPExecutor;
import com.gemini.springboot.web.mybatisv2.mapper.GPMapperProxy;

import java.lang.reflect.Proxy;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.session
 * @classname: GPSqlSession
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 16:55
 */
public class GPSqlSession {
    private GPConfiguration gpConfiguration;
    private GPExecutor executor;

    public GPSqlSession(GPConfiguration gpConfiguration, GPExecutor executor) {
        this.gpConfiguration = gpConfiguration;
        this.executor = executor;
    }

    public <T>T getMapper(Class<T> tClass){
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},new GPMapperProxy(this,tClass));
    }

    public <T>T selectOne(String statement,Object parameter){
        return executor.execute( statement,parameter);
    }
}
