package common.util;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageTransferUtil {
	private static Logger log=Logger.getLogger(MessageTransferUtil.class);
	public static void jsonToXml(Element context,JSONObject obj){
		Iterator<String> iters=obj.keys();
		while(iters.hasNext()){
			String key=iters.next();
			Object value=obj.get(key);
			if(value instanceof JSONArray){  //是array类型
				JSONArray jsonArray=(JSONArray)value;
				for(int i=0;i<jsonArray.length();i++){  //循环处理
					Element ele=context.addElement(key);
					Object obj1=jsonArray.get(i);
					if(obj1 instanceof JSONObject){
						jsonToXml(ele, (JSONObject)obj);   //递归调用
					}else{
						ele.addText((String)obj1);
					}
				}
				
			}else if(value instanceof JSONObject){   //jsonObject类型
				Element ele=context.addElement(key);
				jsonToXml(ele, (JSONObject)value);
			}else{				//其他
				Element ele=context.addElement(key);
				ele.addText(value.toString());
			}
		}
		log.info(context.asXML());
		
		XMLUtil.getNodes(context);   //遍历演示
		
	}
	
	
}
