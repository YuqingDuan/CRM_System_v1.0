package cn.hfut.ssh.dao;

import cn.hfut.ssh.domain.User;

/**
 * 用户管理的DAO接口
 * 
 * @author Yuqing
 */
public interface UserDao extends BaseDao<User> {
	User login(User user);
}
