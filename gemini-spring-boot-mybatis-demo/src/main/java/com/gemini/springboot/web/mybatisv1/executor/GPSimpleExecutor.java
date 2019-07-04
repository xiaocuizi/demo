package com.gemini.springboot.web.mybatisv1.executor;

import com.gemini.springboot.web.mybatisv1.entity.Test;

import java.sql.*;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.springboot.web.mybatisv1.executor
 * @classname: GPSimpleExecutor
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/1/8 17:28
 */
public class GPSimpleExecutor implements GPExecutor {
    @Override
    public <T>T execute(String statement, Object parameter) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(statement, Integer.parseInt(String.valueOf(parameter))));
            ResultSet resultSet = preparedStatement.executeQuery();
            Test test = new Test();
            //
            while (resultSet.next()) {
                test.setId(resultSet.getInt(1));
                test.setNums(resultSet.getInt(2));
                test.setName(resultSet.getString(3));
            }
            return (T) test;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConnection() {
        //驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.81.131:3306/my_learn?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String pwd = "newpass@123";
        Connection connection = null;
        try {
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url, username, pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //连接
        return connection;
    }
}
