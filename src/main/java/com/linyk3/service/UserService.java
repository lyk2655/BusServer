package com.linyk3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linyk3.bean.LoginLog;
import com.linyk3.bean.User;
import com.linyk3.dao.LoginLogDao;
import com.linyk3.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	@Autowired
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String name, String password) {
		int matchCount = userdao.getMatchCount(name, password);
		return matchCount > 0;
	}

	public User findUserByUsername(String username) {
		return userdao.findUserByName(username);
	}

	public void loginSuccess(User user) {
		System.out.println("loginSuccess"+user);
		user.setCredits(user.getCredits() + 5);
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		System.out.println("loginSuccess"+loginLog);
		userdao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
}
