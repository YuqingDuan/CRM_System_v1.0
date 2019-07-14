package cn.hfut.ssh.dao.impl;

import java.util.List;
import cn.hfut.ssh.dao.UserDao;
import cn.hfut.ssh.domain.User;

/**
 * 用户管理的DAO实现类
 * 
 * @author Yuqing
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	// DAO中根据用户名和密码进行查询的方法:
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find(
				"from User where user_code=? and user_password = ?", user.getUser_code(), user.getUser_password());
		// 判断一下:
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
