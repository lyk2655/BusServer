package com.linyk3.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.linyk3.bean.User;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
	public int getMatchCount(String name, String password) {
        String sql = "SELECT count(*) FROM t_user WHERE user_name = ? and password = ?";
        return jdbcTemplate.queryForInt(sql, new Object[] { name, password });
    }

    public User findUserByName(final String name) {
        String sql = "select * from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[] { name }, new RowCallbackHandler() {

            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(name);
                user.setCredits(rs.getInt("credits"));
                user.setPassword(rs.getString("password"));
                user.setLastIp(rs.getString("last_ip"));
                user.setLastVisit(rs.getDate("last_visit"));   
            }
        });
        System.out.println("UserDao"+user);
        return user;
    }

    public void updateLoginInfo(User user) {
        String sql = "update t_user set last_visit = ?,last_ip = ?, credits = ? where user_id = ?";
        jdbcTemplate.update(sql,
                new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId() });
    }
}