package com.controller.getui;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.getui.IPushMsgService;

import common.ParamConstant;
import common.bean.MessageUser;
import common.bean.RequestBody;

@Controller
@RequestMapping("/getui")
public class PushMsgController {
	@Autowired
	private IPushMsgService pushMsgServiceImpl;
	
	@RequestMapping(value="/pushSingle.do",method=RequestMethod.GET)
	public Map<String,Object> pushSingle(){
		//≈‰÷√requestBody
		RequestBody requestBody=new RequestBody();
		requestBody.setAppey(ParamConstant.AppKey);
		requestBody.setAppId(ParamConstant.AppID);
		requestBody.setMasterSecret(ParamConstant.MasterSecret);
		requestBody.setClientId("094680cc14485f5eb9fc86b2f52d93fb");
		
		return pushMsgServiceImpl.pushToSingle(requestBody);
	}
	
	@RequestMapping(value="/pushArray.do",method=RequestMethod.GET)
	public Map<String,Object> pushArray(){
		//≈‰÷√requestBody
		RequestBody requestBody=new RequestBody();
		requestBody.setAppey(ParamConstant.AppKey);
		requestBody.setAppId(ParamConstant.AppID);
		requestBody.setMasterSecret(ParamConstant.MasterSecret);
		MessageUser user1=new MessageUser();
		user1.setClientId("094680cc14485f5eb9fc86b2f52d93fb");
		MessageUser user2=new MessageUser();
		user2.setClientId("db6253f5abe8ee008820fc38e203a145");
		requestBody.setUser(new MessageUser[]{user1,user2});
		return pushMsgServiceImpl.pushToArray(requestBody);
	}
	
}
