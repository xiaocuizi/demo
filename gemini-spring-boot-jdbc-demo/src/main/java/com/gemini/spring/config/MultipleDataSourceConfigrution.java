package com.gemini.spring.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.config
 * @classname: MultipleDataSourceConfigrution
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/22 11:36
 */
@Configuration
public class MultipleDataSourceConfigrution {

    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    //private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    //private static final String MYSQL_URL_MASTER = "jdbc:mysql://192.168.81.131:3306/my_user";
    //private static final String MYSQL_URL_SLAVE = "jdbc:mysql://192.168.81.131:3306/my_learn";
    private static final String MYSQL_URL_MASTER = "jdbc:mysql://192.168.81.131:3306/my_user?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    private static final String MYSQL_URL_SLAVE = "jdbc:mysql://192.168.81.131:3306/my_learn?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "newpass@123";

    /**
     *
     * @return
     */
    @Bean
    @Primary
    public DataSource masterDataSource(){
       return DataSourceBuilder.create().driverClassName(MYSQL_DRIVER).url(MYSQL_URL_MASTER).username(MYSQL_USERNAME).password(MYSQL_PASSWORD).build();
    }


    /**
     *
     * @return
     */

    @Bean
    public DataSource slaveDataSource(){
        return DataSourceBuilder.create().driverClassName(MYSQL_DRIVER).url(MYSQL_URL_SLAVE).username(MYSQL_USERNAME).password(MYSQL_PASSWORD).build();
    }


}
