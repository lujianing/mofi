package qianyan.mofi.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;





@Repository
public class PageDaoImpl extends BaseDaoImpl implements PageDao {
	
	/** *//** 
	 * 分页查询 
	 * @param <T>
	 * @param hql 查询的条件 
	 * @param offset 开始记录 
	 * @param length 一次查询几条记录 
	 * @return 
	 */
	
	public List queryForPage(String hql, int offset, int length) {
		
		EntityManager entityManager = this.emf.createEntityManager();
		
		
		Query query = (Query) entityManager.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List list =query.getResultList();
		
		
		
		
		return list;
		  
	}
	
	/** *//** 
	 * 查询所有记录数 
	 * @return 总记录数 
	 */ 
	
	public int getAllRowCount(String hql) {
		
		return this.getJpaTemplate().find(hql).size();
	}

}
