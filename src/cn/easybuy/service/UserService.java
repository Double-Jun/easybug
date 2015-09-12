package cn.easybuy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easybuy.dao.UserDao;
import cn.easybuy.domain.User;

@Service
public class UserService {

	@Resource
	private UserDao userDao;

	/** 用户注册 */
	public void regist(User user) {
		userDao.insert(user);
	}

	/** 用户登录 */
	public User login(String username, String password) {
		return userDao.verifyUser(username, password);
	}

}
