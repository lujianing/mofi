package qianyan.mofi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import qianyan.mofi.entity.ApplyInfo;

@Repository
public class ApplyInfoDaoImpl extends BaseDaoImpl<ApplyInfo, Long> implements ApplyInfoDao {


	
	public List<ApplyInfo> listbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ApplyInfo> listbyPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<ApplyInfo> listByState(String type,String sort) {
		System.out.println(sort);
		return super.getJpaTemplate().find("from ApplyInfo a where a.state=? order by time "+sort,type);
	}

}
