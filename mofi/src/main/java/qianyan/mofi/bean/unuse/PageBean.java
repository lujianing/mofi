package qianyan.mofi.bean.unuse;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long totalProperty;
	private List<T> root;
	
	public PageBean() {
		this.totalProperty = 0;
		this.root = new ArrayList<T>();
	}

	public PageBean(int totalProperty, List<T> root) {
		this.totalProperty = totalProperty;
		this.root = root;
	}

	public long getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(long totalProperty) {
		this.totalProperty = totalProperty;
	}

	public List<T> getRoot() {
		return root;
	}

	public void setRoot(List<T> root) {
		this.root = root;
	}

}
