package com.gemini.spring.repository;

import com.gemini.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xiaocuzi
 * @version v1.0.0
 * @package com.gemini.spring.repository
 * @classname: UserRepository
 * @description: todo (用一句话描述该文件做什么)
 * @date 2019/2/21 21:16
 */
@Repository
public class UserRepository {

    private final DataSource dataSource;

    private final DataSource masterDataSource;

    private final DataSource slaveDataSource;


    private final JdbcTemplate jdbcTemplate ;

    @Autowired
    public UserRepository(DataSource dataSource,
                          @Qualifier("masterDataSource") DataSource masterDataSource,
                          @Qualifier("slaveDataSource") DataSource slaveDataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.masterDataSource = masterDataSource;
        this.slaveDataSource = slaveDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     *
     * @param user1
     * @return
     */
    @Transactional
    public boolean saveUser(User user1) {
        boolean success = false;
        success = jdbcTemplate.execute("insert into tc_user(name,age) values (?,?)", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, user1.getName());
                preparedStatement.setInt(2, user1.getAge());
                return preparedStatement.executeUpdate() > 0;
            }
        });
        if(success){
            try {
                throw new NullPointerException("空指针。。");
            } catch (NullPointerException e) {
                System.out.println("空指针=");
                e.printStackTrace();
            }
        }
        return success;
    }

    /**
     *
     * @param user1
     * @return
     */
    public boolean saveUser2(User user1){
            System.out.println("user1=" + user1);
            Connection connection = null;
            boolean success = false;
            try {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into tc_user(name,age) values (?,?)");
                preparedStatement.setString(1, user1.getName());
                preparedStatement.setInt(2, user1.getAge());
                success = preparedStatement.executeUpdate() > 0;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.commit();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return success;
        }

    }




