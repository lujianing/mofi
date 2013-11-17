package qianyan.mofi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qianyan.mofi.bean.PageBean;
import qianyan.mofi.dao.ApplyInfoDao;
import qianyan.mofi.dao.PageDao;
import qianyan.mofi.entity.ApplyInfo;

@Service
public class ApplyInfoService implements BaseService<ApplyInfo, Long> {
	@Autowired
	private ApplyInfoDao applyInfoDao;

	@Autowired
	private PageDao pageDao;

	// private ApplyInfoDao applyInfoDao = new ApplyInfoDaoImpl();
	
	public void save(ApplyInfo entity) {
		System.out.println(entity.getMdbh());
		applyInfoDao.save(entity);

	}

	public List<ApplyInfo> listUnExamine() {
		return applyInfoDao.listByState("等待审核", "asc");

	}

	public List<ApplyInfo> listPassApplyInfo() {
		return applyInfoDao.listByState("通过审核", "asc");

	}

	public List<ApplyInfo> listOverApplyInfo() {
		return applyInfoDao.listByState("完成交易", "desc");

	}

	public int updateState(String[] list, String type) {
		int i = 0;
		for (; i < list.length; i++) {
			Long id = Long.parseLong(list[i]);
			ApplyInfo applyinfo = applyInfoDao.findById(ApplyInfo.class, id);
			applyinfo.setState(type);
			applyInfoDao.update(applyinfo);
		}
		return i;
	}

	
	public void delete(ApplyInfo entity) {
		applyInfoDao.delete(entity);

	}

	
	public void deleteById(Class<ApplyInfo> entityClass, Long id) {
		// TODO Auto-generated method stub

	}

	
	public void update(ApplyInfo applyinfo) {
		applyInfoDao.update(applyinfo);

	}

	
	public ApplyInfo findById(Class<ApplyInfo> entityClass, Long id) {
		ApplyInfo applyinfo = applyInfoDao.findById(ApplyInfo.class, id);
		return applyinfo;
	}

	
	public List<ApplyInfo> findAll(Class<ApplyInfo> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 分页查询，返回个性化定制过的数据格式，page参数用于传递查询条件和带回查询结果
	 * 
	 * @param clazz
	 * @param page
	 */
	/*
	 * public PageBean<Map<String, Object>> findPage(final Class<ApplyInfo>
	 * clazz, Page<ApplyInfo> page){
	 * 
	 * PageBean<Map<String, Object>> result = new PageBean<Map<String,
	 * Object>>();
	 * 
	 * Long count = this.applyInfoDao.findPage(clazz, page); //设置记录总数
	 * result.setTotalProperty(count);
	 * 
	 * List<ApplyInfo> pageData = page.getResult();
	 * 
	 * List<Map<String, Object>> pagecontent = new
	 * ArrayList<Map<String,Object>>(); //将查询结果集转换为json转换器需要的格式
	 * this.pageHandler(pagecontent,pageData);
	 * 
	 * result.setRoot(pagecontent);
	 * 
	 * return result; }
	 */
	/**
	 * 数据页处理，将得到的分页数据进行个性化的定制，比如分页得到的是List<Operator>
	 * 那么就需要将operator的各基本类型属性（String，int，Long等）提取出来，而将
	 * 复杂类型属性转换为基本类型，如operator的merchant属性类型为Merchant，取其name属性
	 * 该转换操作迭代深度为一层;将List<T>装换为List<Map<String,Object>>
	 * 
	 * @param pagecontent
	 *            , pageData
	 * @return
	 */
	/*
	 * protected void pageHandler(List<Map<String, Object>> pagecontent,
	 * List<ApplyInfo> pageData) { for(ApplyInfo applyinfo:pageData){
	 * Map<String,Object> map=new HashMap<String ,Object>(); map.put("id",
	 * applyinfo.getId()); map.put("hwbh", applyinfo.getHwbh()); map.put("hwsl",
	 * applyinfo.getHwsl()); map.put("mdbh", applyinfo.getMdbh());
	 * map.put("name", applyinfo.getName()); map.put("phone",
	 * applyinfo.getPhone()); map.put("userid", applyinfo.getUserid());
	 * map.put("state", applyinfo.getState()); map.put("time",
	 * applyinfo.getTime()); pagecontent.add(map); } }
	 */

	/**
	 * type 订单的状态
	 * sort 排序asc desc
	 ** 分页查询 　　 * @param currentPage 当前第几页 　　 * @param pageSize 每页大小 　　 * @return
	 * 封闭了分页信息(包括记录集list)的Bean 　　
	 */

	public PageBean queryForPage(int pageSize, int page,String type,String sort) {

		final String hql = "from ApplyInfo a where a.state='"+type+"' order by time "+sort;// 查询语句
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
