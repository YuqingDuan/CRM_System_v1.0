package cn.hfut.ssh.dao.impl;

import java.util.List;
import cn.hfut.ssh.dao.BaseDictDao;
import cn.hfut.ssh.domain.BaseDict;

/**
 * 字典DAO的实现类
 * 
 * @author Yuqing
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {
	// 根据类型编码查询字典数据
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?",
				dict_type_code);
	}
}
