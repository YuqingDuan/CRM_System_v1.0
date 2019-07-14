package cn.hfut.ssh.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.hfut.ssh.domain.LinkMan;
import cn.hfut.ssh.domain.PageBean;

/**
 * 联系人的Service接口
 * 
 * @author Yuqing
 */
public interface LinkManService {
	PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);
}
