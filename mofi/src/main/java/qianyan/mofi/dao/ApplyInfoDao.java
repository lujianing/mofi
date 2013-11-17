package qianyan.mofi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qianyan.mofi.entity.ApplyInfo;
@Transactional
public interface ApplyInfoDao extends BaseDao<ApplyInfo, Long> {
	public List<ApplyInfo> listbyName(String name);
	public List<ApplyInfo> listbyPhone(String phone);
	public List<ApplyInfo> listByState(String type, String sort);
}
