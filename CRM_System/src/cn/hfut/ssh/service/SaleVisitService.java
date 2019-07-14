package cn.hfut.ssh.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.hfut.ssh.domain.PageBean;
import cn.hfut.ssh.domain.SaleVisit;

/**
 * 客户拜访记录的业务层接口
 * 
 * @author Yuqing
 */
public interface SaleVisitService {
	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);
}
