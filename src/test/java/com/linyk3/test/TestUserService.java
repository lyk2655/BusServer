package com.linyk3.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linyk3.bean.User;
import com.linyk3.service.UserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml","/spring-mybatis.xml"})
public class TestUserService {
    @Autowired
    private UserServiceImpl userService;
    
    @Test
    public void getUserByUsername(){
        User user = userService.getUserByUsername("linyk3");
        System.out.println("getUserByUsername"+user.toString());
        assertEquals(user.getUserName(), "linyk3");

    }
}