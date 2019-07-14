package cn.hfut.ssh.service;

import java.util.List;
import cn.hfut.ssh.domain.BaseDict;

/**
 * 字典的业务层接口
 * 
 * @author Yuqing
 */
public interface BaseDictService {
	List<BaseDict> findByTypeCode(String dict_type_code);
}
