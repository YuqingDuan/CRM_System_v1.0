package cn.hfut.ssh.service;

import java.util.List;

import cn.hfut.ssh.domain.User;

/**
 * 用户管理的Service接口
 * 
 * @author Yuqing
 */
public interface UserService {
	void regist(User user);

	User login(User user);

	List<User> findAll();
}
