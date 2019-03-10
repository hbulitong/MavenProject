package com.service.impl.getui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.service.getui.IPushMsgService;

import common.MessageTemplateFactory;
import common.ParamConstant;
import common.bean.MessageUser;
import common.bean.RequestBody;
/**
 * 个推推送消息服务
 * @author Administrator
 *
 */
@Service
public class PushMsgServiceImpl implements IPushMsgService{
	
	private Logger log=Logger.getLogger(this.getClass());
	
	/**
	 * 推送消息到APP单个用户
	 */
	public Map<String, Object> pushToSingle(RequestBody requsetBody) {
		Map<String,Object> result=new HashMap<String,Object>();
		//建立链接，初始化
		IGtPush push = new IGtPush(ParamConstant.Host,requsetBody.getAppey(), requsetBody.getMasterSecret());
		TransmissionTemplate template = MessageTemplateFactory.getTransmissionTemplate(requsetBody);
		LinkTemplate template1=MessageTemplateFactory.getlinkTemplateDemo(requsetBody);
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template1);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0); 
        Target target = new Target();
        target.setAppId(requsetBody.getAppId());
        target.setClientId(requsetBody.getClientId());
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            log.info(ret.getResponse().toString());
            result.put("ret", ret.getResponse().toString());
        } else {
            log.info("服务器响应异常");
            result.put("ret", "服务器响应异常");
        }
        return result;
        
		
	}
	/**
	 * 推送消息到APP多个用户
	 * @param requsetBody
	 * @return
	 */
	public Map<String, Object> pushToArray(RequestBody requsetBody){
		log.info("组推开始++++++++++++++");
		Map<String,Object> result=new HashMap<String,Object>();
		//建立链接，初始化
		IGtPush push = new IGtPush(ParamConstant.Host,requsetBody.getAppey(), requsetBody.getMasterSecret());
		TransmissionTemplate template = MessageTemplateFactory.getTransmissionTemplate(requsetBody);
		//创建通知模版
		LinkTemplate template1=MessageTemplateFactory.getlinkTemplateDemo(requsetBody);
		ListMessage message=new ListMessage(); //和推送到单个用户有区别
		message.setData(template1); //设置模版
		// 设置消息离线，并设置离线时间
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24*1000*3600);
		//配置推送目标
		ArrayList<Target> targets=new ArrayList<Target>();
		MessageUser[] messageUser=requsetBody.getUser();
		for(MessageUser user:messageUser){		//循环处理
			Target target=new Target();
			target.setAppId(requsetBody.getAppId());
			log.info("用户CID:"+user.getClientId());
			target.setClientId(user.getClientId());
			targets.add(target);
		}
		// taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = null;
        try{
        	ret=push.pushMessageToList(taskId, targets);
        }catch(RequestException e){
        	e.printStackTrace();
        }
        
        if (ret != null) {
            log.info(ret.getResponse().toString());
            result.put("ret", ret.getResponse().toString());
        } else {
            log.info("服务器响应异常");
            result.put("ret", "服务器响应异常");
        }
        return result;
	}
	
	

}
