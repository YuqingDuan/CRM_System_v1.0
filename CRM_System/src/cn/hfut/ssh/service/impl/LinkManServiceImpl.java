package cn.hfut.ssh.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;
import cn.hfut.ssh.dao.LinkManDao;
import cn.hfut.ssh.domain.LinkMan;
import cn.hfut.ssh.domain.PageBean;
import cn.hfut.ssh.service.LinkManService;

/**
 * 联系人的Service实现类
 * 
 * @author Yuqing
 */
@Transactional
public class LinkManServiceImpl implements LinkManService {
	// 注入DAO层对象
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	// 业务层分页查询联系人的方法
	public PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		// 设置当前页数:
		pageBean.setCurrPage(currPage);
		// 设置每页显示记录数:
		pageBean.setPageSize(pageSize);
		// 设置总记录数
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 每页显示数据的集合
		Integer begin = (currPage - 1) * pageSize;
		List<LinkMan> list = linkManDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层保存联系人的方法
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}

	// 业务层根据ID查询联系人的方法
	public LinkMan findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);
	}

	// 业务层修改联系人的方法
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}

	// 业务层删除联系人的方法:
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
}
