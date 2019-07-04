package com.gemini.springboot.web.mybatisv1.mapper;

import com.gemini.springboot.web.mybatisv1.config.TestMapperXml;
import com.gemini.springboot.web.mybatisv1.session.GPSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.mapper
 * @classname: GPMapperProxy
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 17:16
 */
public class GPMapperProxy<T> implements InvocationHandler {
    private final GPSqlSession gpSqlSession;
    private final Class<T> mapperInterface;

    public GPMapperProxy(GPSqlSession gpSqlSession, Class<T> tClass) {
        this.gpSqlSession = gpSqlSession;
        this.mapperInterface = tClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().equals(proxy.getClass())){
            return method.invoke(proxy, args);
        }
        //String statement,Object parameter
        TestMapperXml.MetaDatas metaDatas = (TestMapperXml.MetaDatas)TestMapperXml.getSqlByNameSpace(proxy.getClass().getName());
        return gpSqlSession.selectOne(metaDatas.getSql(),metaDatas.getParammeters());
    }

}
