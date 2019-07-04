package com.gemini.springboot.web.mybatisv1.plugins;

import com.gemini.springboot.web.mybatisv1.executor.GPExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.plugins
 * @classname: pluginDemo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/12 12:16
 */
@Intercepts(@Signature(type= Executor.class,
        method = "query",args ={MappedStatement.class,Object.class,RowBounds.class, ResultHandler.class}))
//RowBounds.class, ResultHandler.class
public class pluginDemo implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);
        System.out.println(String.format("plugin output sql = %s , param=%s", boundSql.getSql(),boundSql.getParameterObject()));
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
