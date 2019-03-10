package com.base.dao;

import java.util.List;
import java.util.Map;

public interface IBaseMybatisDao {
	public Map<String,Object> selectOne(String statementName,Object map);
	public List selectList(String statementName,Object map);
}
