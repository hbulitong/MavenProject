package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
/*@PropertySource("classpath:db-config.properties")*/
public class AnnotationControllerTwo {
	@Value("${db.username}")	/*获取配置文件的属性值*/
	private String username;
	private static final Logger logger=Logger.getLogger(AnnotationControllerTwo.class);
	@RequestMapping(value="annotation2.li")
	@ResponseBody
	public void execute(HttpServletRequest request,HttpServletResponse response,
			ModelMap context){
		logger.info(context.get("username"));
		Map<String,Object> res=new HashMap<String,Object>();
		logger.info("value-test:"+username);
		res.put("retMsg", "success");
		try {
			response.getWriter().write(JSONObject.fromObject(res).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
