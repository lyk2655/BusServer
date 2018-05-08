package com.linyk3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linyk3.bean.User;
import com.linyk3.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
    private UserMapper userMapper;

	@Override
	public User getUserByUsername(String username) {

        User user = userMapper.selectUser1(username);
        System.out.println("AAAAAAAAAAAAAAAAAA"+user);
        return user;

    }
	
}
