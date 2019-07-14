package cn.hfut.ssh.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;
import cn.hfut.ssh.dao.CustomerDao;
import cn.hfut.ssh.domain.Customer;
import cn.hfut.ssh.domain.PageBean;
import cn.hfut.ssh.service.CustomerService;

/**
 * 客户管理的Service实现类
 * 
 * @author Yuqing
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
	// 注入客户的DAO
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	// 业务层保存客户的方法:
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	// 业务层分页查询客户的方法:
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		// 封装当前页数:
		pageBean.setCurrPage(currPage);
		// 封装每页显示记录数:
		pageBean.setPageSize(pageSize);
		// 封装总记录数:
		// 调用DAO:
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		// 封装总页数:
		Double tc = totalCount.doubleValue();
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示数据的集合
		Integer begin = (currPage - 1) * pageSize;
		List<Customer> list = customerDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层根据ID查询客户的方法
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}

	// 业务层删除客户的方法
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	// 业务层修改客户的方法
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	// 业务层查询所有客户的方法
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
}
