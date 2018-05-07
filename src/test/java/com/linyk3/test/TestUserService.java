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
import com.linyk3.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchedUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1236");
        boolean b3 = userService.hasMatchUser("admin", "111111");

        System.out.println("b1["+b1+"],b2["+b2+"]");
        assertTrue(!b1);
        assertTrue(!b2);
        assertTrue(b3);
    }
    
    @Test
    public void findUserByUsername(){
        User user = userService.findUserByUsername("admin");
        System.out.println("findUserByUsername"+user.toString());
        assertEquals(user.getUserName(), "admin");
        user.setLastIp("192.168.11.188");
        user.setLastVisit(new Timestamp(new Date().getTime()));
        userService.loginSuccess(user);
    }
    
}