package qianyan.mofi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qianyan.mofi.bean.PageBean;
import qianyan.mofi.dao.MessageDao;
import qianyan.mofi.dao.PageDao;
import qianyan.mofi.entity.ApplyInfo;
import qianyan.mofi.entity.Message;

@Service
public class MessageService implements BaseService<Message, Long> {
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private PageDao pageDao;
	
	public void save(Message entity) {
		messageDao.save(entity);		
	}

	
	public void delete(Message entity) {
		messageDao.delete(entity);
		
	}

	
	public void deleteById(Class<Message> entityClass, Long id) {
		messageDao.deleteById(entityClass, id);
		
	}

	
	public void update(Message entity) {
		messageDao.update(entity);
		
	}

	
	public Message findById(Class<Message> entityClass, Long id) {
		
		return messageDao.findById(entityClass, id);
	}

	
	public List<Message> findAll(Class<Message> entityClass) {
		return messageDao.findAll(entityClass);
	
	}
	
	public PageBean queryForPage(int pageSize, int page,String sort) {

		final String hql = "from Message  order by time "+sort;// 查询语句
		int allRow = pageDao.getAllRowCount(hql);// 总记录数
		System.out.println(allRow);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);// 总页数
		final int offset = PageBean.countOffset(pageSize, page);// 当前页开始记录
		final int length = pageSize;// 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<ApplyInfo> list = pageDao.queryForPage(hql, offset, length);// "一页"的记录

		PageBean pagebean = new PageBean();
		pagebean.setPageSize(pageSize);
		pagebean.setCurrentPage(currentPage);
		pagebean.setAllRow(allRow);
		pagebean.setTotalPage(totalPage);
		pagebean.setList(list);
		pagebean.init();
		return pagebean;
	}

}
