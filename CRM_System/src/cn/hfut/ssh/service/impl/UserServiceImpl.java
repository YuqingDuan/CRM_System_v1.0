package cn.hfut.ssh.service.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import cn.hfut.ssh.dao.UserDao;
import cn.hfut.ssh.domain.User;
import cn.hfut.ssh.service.UserService;
import cn.hfut.ssh.utils.MD5Utils;

/**
 * 用户管理的Service实现类
 * 
 * @author Yuqing
 */
@Transactional
public class UserServiceImpl implements UserService {
	// 注入DAO
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 业务层注册用户的方法
	public void regist(User user) {
		// 对密码进行加密处理：
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		// 调用DAO
		userDao.save(user);
	}

	// 业务层用户登录的方法
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		// 调用DAO
		return userDao.login(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}
}
