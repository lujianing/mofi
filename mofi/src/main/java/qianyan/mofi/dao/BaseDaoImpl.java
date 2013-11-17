package qianyan.mofi.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import qianyan.mofi.bean.unuse.Page;
import qianyan.mofi.utils.ReflectionUtils;


@Repository
public class BaseDaoImpl<T,ID extends Serializable>extends JpaDaoSupport implements BaseDao<T, ID> {
		
	@Autowired
	@Qualifier("entityManagerFactory")
	protected EntityManagerFactory emf;
	
	@PostConstruct
	public void postConstruct(){
		this.setEntityManagerFactory(this.emf);
	}
	
	
	public void save(T entity) {
		System.out.println("采用JPA存储");
		this.getJpaTemplate().persist(entity);		
	}

	
	public void delete(T entity) {
		this.getJpaTemplate().remove(getJpaTemplate().merge(entity));
		
	}

	
	public void deleteById(Class<T> entityClass, ID id) {
		delete(this.findById(entityClass, id));
		
	}

	
	public void update(T entity) {
		this.getJpaTemplate().merge(entity);
		
	}
	
	
	

	
	public T findById(Class<T> entityClass, ID id) {
		return (T)this.getJpaTemplate().find(entityClass, id);
	}

	
	public List<T> findAll(Class<T> entityClass) {
		String name = entityClass.getName();
		return this.getJpaTemplate().find("from "+name);
	}
	
	/**
	 * 分页查询，返回在当前过滤条件下查询结果总数，page参数用于传递查询条件和带回查询结果
	 * @param clazz
	 * @param page
	 */
/*	@SuppressWarnings("unchecked")
	public Long findPage(final Class<T> clazz,Page<T> page){
		String order = null==page.getOrder()||page.getOrder().length()<1?"":" "+page.getOrder();
		String orderBy = null==page.getOrderBy()||page.getOrderBy().length()<1?" ":" order by "+page.getOrderBy()+order;
		String entityName = ReflectionUtils.getClassName(clazz);
		String jpql = "select e from "+entityName+" e "+page.getWhereCondition()+orderBy;
		logger.info(jpql);
		EntityManager entityManager = this.emf.createEntityManager();
		Query query = entityManager.createQuery(jpql);
		query.setFirstResult(page.getStart().intValue());
		query.setMaxResults(page.getStart().intValue()+page.getLimit().intValue());
		page.setResult(query.getResultList());
		//得到分页查询的结果总条数
		String jpql2 = "select count(*) from "+entityName+" m "+page.getWhereCondition();
		this.logger.info("分页查询记录总条数语句:"+jpql2);
		return (Long) this.getJpaTemplate().find(jpql2).get(0);
	}
*/
	
	
}
