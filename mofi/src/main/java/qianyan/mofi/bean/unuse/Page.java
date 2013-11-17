package qianyan.mofi.bean.unuse;



import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	//-- 分页参数 --//
	protected Long start = 0L;
	protected Long limit = 2L;
	protected String orderBy = null;
	protected String order = null;
	protected String whereCondition = "where 1=1";
	protected Object memberObj = null;
	
	//-- 返回结果 --//
	protected List<T> result = new ArrayList<T>();
	protected Long totalCount = -1L;
	
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getLimit() {
		return limit;
	}
	public void setLimit(Long limit) {
		this.limit = limit;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getWhereCondition() {
		return whereCondition;
	}
	//这里将从WebUtil工具类得到的and或or条件连接到where 1=1之后
	public void setWhereCondition(String whereCondition) {
		this.whereCondition += whereCondition;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
}
