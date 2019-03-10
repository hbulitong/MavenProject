package common.bean;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Element;

public interface IBusContext {
	//初始化数据总线
	public void jsonToXml();
	
	public String getParam(String key);
}
