package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.controller.base.StandardController;

@Controller
public class AnnotationController extends StandardController {
	@Value("Perfect Is Shit")
	private String username;
	private static final Logger logger=Logger.getLogger(AnnotationController.class);	
	
	@RequestMapping(value="annotation.li",method=RequestMethod.POST)
	public String method(HttpServletRequest request,ModelMap paramMap){
		logger.info(paramMap.get("username"));
		execute(request);
		logger.info("username:"+username);
		return "";
	}
	@Override
	public void realExecute(HttpServletRequest request) throws Exception {
		logger.info("realExecute+++++++++++");
	}

}
