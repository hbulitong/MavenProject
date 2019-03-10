package common;

import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

import common.bean.RequestBody;

/**
 * 个推消息模版
 * @author Administrator
 *
 */
public class MessageTemplateFactory {
	/**
	 * 透传模版
	 * @param req
	 * @return
	 */
	public static TransmissionTemplate getTransmissionTemplate(RequestBody req){
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(req.getAppId());
		template.setAppkey(req.getAppey());
		template.setTransmissionContent("测试用的透传文本");
		template.setTransmissionType(1);
		//如果是IOS设备，要设置APNS相关参数
		//APNPayload payload=new APNPayload();
		return template;
	}
	
	public static LinkTemplate getlinkTemplateDemo(RequestBody requsetBody) {
        LinkTemplate template = new LinkTemplate();
        // 设置APPID与APPKEY
        template.setAppId(requsetBody.getAppId());
        template.setAppkey(requsetBody.getAppey());
        // 设置通知栏标题与内容
        template.setTitle("Single演示");
        template.setText("hbulitong给你发了消息！");
        // 配置通知栏图标
        template.setLogo("icon.png");
        // 配置通知栏网络图标，填写图标URL地址
        template.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        template.setIsRing(true);
        template.setIsVibrate(true);
        template.setIsClearable(true);
        // 设置打开的网址地址
        template.setUrl("http://www.baidu.com");
        return template;
    }
}
