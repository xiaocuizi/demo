package com.gemini.springboot.web.mybatisv2.test;

import com.gemini.springboot.web.mybatisv2.entity.Test;
import com.gemini.springboot.web.mybatisv2.executor.GPSimpleExecutor;
import com.gemini.springboot.web.mybatisv2.mapper.TestMapper;
import com.gemini.springboot.web.mybatisv2.session.GPSqlSession;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.test
 * @classname: TestMybatisV2Demo
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/10 16:45
 */
public class TestMybatisV2Demo {

    public static void main(String[] args) {
        GPSqlSession gpSqlSession = new GPSqlSession(null, new GPSimpleExecutor());
        TestMapper testMapper = gpSqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test.toString());
    }
}
