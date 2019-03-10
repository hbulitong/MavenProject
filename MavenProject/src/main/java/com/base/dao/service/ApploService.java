package com.base.dao.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.IBaseMybatisDao;

@Service
public class ApploService {
	@Autowired
	private IBaseMybatisDao mybatisDao;
	public Map<String,Object> selectById(Map<String,Object> map){
		return mybatisDao.selectOne("com.mapper.RunoobMapper.selectById", map);
	}
	public List selectList(Map<String,Object> map){
		return mybatisDao.selectList("com.mapper.RunoobMapper.selectList", map);
	}
}
