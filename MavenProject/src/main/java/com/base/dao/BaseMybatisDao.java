package com.base.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
/**
 * 数据库操作统一DAO
 * @author hbulitong
 *
 */
public class BaseMybatisDao implements IBaseMybatisDao{
	
	//注入以后就可以直接使用sqlsession
	private SqlSessionTemplate sqlsession;
	public void setSqlsession(SqlSessionTemplate sqlsession) {
		this.sqlsession = sqlsession;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectOne(String statementName, Object map) {
		return (Map<String,Object>)sqlsession.selectOne(statementName, map);
	}

	@Override
	public List selectList(String statementName, Object map) {
		return (List)sqlsession.selectList(statementName, map);
	}
	
}
