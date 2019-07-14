package cn.hfut.ssh.service.impl;

import java.util.List;

import cn.hfut.ssh.dao.BaseDictDao;
import cn.hfut.ssh.domain.BaseDict;
import cn.hfut.ssh.service.BaseDictService;

/**
 * 字典的业务层的实现类
 * 
 * @author Yuqing
 */
public class BaseDictServiceImpl implements BaseDictService {
	// 注入DAO
	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}
}
