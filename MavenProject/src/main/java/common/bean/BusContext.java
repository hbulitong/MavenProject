package common.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.json.JSONObject;

import common.ParamConstant;
import common.util.MessageTransferUtil;


public class BusContext implements IBusContext{
	private Logger log=Logger.getLogger(BusContext.class);
	private HttpServletRequest request;
	private HttpSession session;
	private Element root;
	//请求参数
	private Element params;
	//响应
	private Element response;
	//初始化
	public BusContext(HttpServletRequest request){
		this.request=request;
		this.session=request.getSession();
		init();
	}
	/**
	 * 初始化
	 */
	private void init(){
		Document doc=DocumentHelper.createDocument();  //创建document对象
		doc.setXMLEncoding("utf-8");  //设置编码格式
		root=doc.addElement("root");
		params=root.addElement("params");
	}

	@Override
	public void jsonToXml(){
		String json=(String)this.request.getAttribute(ParamConstant.REQUESTPARAM);
		log.info("参数："+json.toString()); 
		JSONObject jsonObj=null;
		//if(json instanceof JSONObject){
			jsonObj=new JSONObject(json);
			MessageTransferUtil.jsonToXml(params, jsonObj);
		//}else{
			//log.info("传输数据格式有误！");
		//}
	}
	@Override
	public String getParam(String key) {
		try{
			Node node=params.selectSingleNode(key);  //获取单个节点，如果有多个，则返回第一个
			if(node!=null){
				return node.getText();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
