package qianyan.mofi.dao;

import org.springframework.transaction.annotation.Transactional;

import qianyan.mofi.entity.Message;
@Transactional
public interface MessageDao extends BaseDao<Message, Long> {

}
