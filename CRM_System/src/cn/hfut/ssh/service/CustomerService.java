package cn.hfut.ssh.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import cn.hfut.ssh.domain.Customer;
import cn.hfut.ssh.domain.PageBean;

/**
 * 客户管理的Service接口
 * 
 * @author Yuqing
 */
public interface CustomerService {
	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();
}
