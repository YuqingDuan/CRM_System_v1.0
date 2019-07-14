package cn.hfut.ssh.dao;

import java.util.List;
import cn.hfut.ssh.domain.BaseDict;

/**
 * 字典DAO的接口
 * 
 * @author Yuqing
 */
public interface BaseDictDao extends BaseDao<BaseDict> {
	List<BaseDict> findByTypeCode(String dict_type_code);
}
