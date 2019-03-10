package common.bean;
/**
 * 特推消息上送的RequestBody
 * @author Administrator
 *
 */
public class RequestBody {
	private String appId; //消息推送的appid
	private String appey; //消息推送的appkey
	private String masterSecret; //消息推送的masterSecret
	private String phoneType; //手机类型IOS OR android
	private String clientId; //推送用户唯一标识
	private MessageUser[] user;
	public MessageUser[] getUser() {
		return user;
	}
	public void setUser(MessageUser[] user) {
		this.user = user;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppey() {
		return appey;
	}
	public void setAppey(String appey) {
		this.appey = appey;
	}
	public String getMasterSecret() {
		return masterSecret;
	}
	public void setMasterSecret(String masterSecret) {
		this.masterSecret = masterSecret;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
