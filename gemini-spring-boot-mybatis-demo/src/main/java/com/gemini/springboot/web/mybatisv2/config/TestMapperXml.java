package com.gemini.springboot.web.mybatisv2.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.config
 * @classname: TestMapperXml
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 17:55
 */
public class TestMapperXml {
    /**
     * 命名空间
     */
    private static String nameSpace ="com.gemini.springboot.web.mybatisv1.mapper.TestMapper";

    private static Map<String,Object> metaDatas  = new HashMap<String,Object>();


    static {
        metaDatas.put(nameSpace, new MetaDatas("select * from test where id =%s", 1));
    }


    /**
     * 获取sql和参数
     * @param nameSpace2
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getSqlByNameSpace(String nameSpace2) throws Exception {
        if (!metaDatas.containsKey(nameSpace)) {
            throw new Exception("没有该命名空间，请检查。。");
        }
        return (T) metaDatas.get(nameSpace);
    }
    public static class MetaDatas {
        private String sql;
        private Object parameters;

        public MetaDatas(String sql, Object parammeters) {
            this.sql = sql;
            this.parameters = parammeters;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Object getParammeters() {
            return parameters;
        }

        public void setParammeters(Object parammeters) {
            this.parameters = parammeters;
        }
    }
}
