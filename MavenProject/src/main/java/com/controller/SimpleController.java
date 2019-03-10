package com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.base.dao.service.ApploService;
import com.controller.base.StandardController;
import com.mapper.RunoobMapper;

@Controller
@RequestMapping("/test")
public class SimpleController extends StandardController{
	
	private static Logger log=Logger.getLogger(StandardController.class);
	@Autowired
    private RunoobMapper runoobMapper;
	@Autowired
	private ApploService apploService;
	
	@RequestMapping(value="simple.li",method=RequestMethod.POST)
	@ResponseBody
	public String simple(HttpServletRequest request){
		execute(request);
		return "";
	}

	@Override
	public void realExecute(HttpServletRequest request) throws Exception {
		log.info(context.get().getParam("user"));
		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("runoob_title", "spring");
//		map.put("runoob_author", "李同");
//		int num=runoobMapper.insertOneRow(map);
//		log.info("影响条数:"+num);
		map.put("runoob_author", "李同");
		List result=apploService.selectList(map);
		log.info(result.toString());
		
	}
	
	
}
