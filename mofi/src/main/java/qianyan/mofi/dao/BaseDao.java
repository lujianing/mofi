package qianyan.mofi.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import qianyan.mofi.bean.unuse.Page;

@Transactional
public interface BaseDao<T,ID extends Serializable> {  
    public void save(T entity);  
    public void delete(T entity);  
    public void deleteById(Class<T> entityClass,ID id);  
    public void update(T entity);  
 
    public T findById(Class<T> entityClass,ID id);  
    public List<T> findAll(Class<T> entityClass);
    
     
} 
