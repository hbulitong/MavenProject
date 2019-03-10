package common.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Element;

public class XMLUtil {
	
	private static final Logger log=Logger.getLogger(XMLUtil.class);
	/**
	 * 从指定节点开始,递归遍历所有子节点
	 * @author chenleixing
	 */
	public static void getNodes(Element node){
		log.info("--------------------");
		
		//当前节点的名称、文本内容和属性
		log.info("当前节点名称："+node.getName());//当前节点名称
		log.info("当前节点的内容："+node.getTextTrim());//当前节点内容
		List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
		for(Attribute attr:listAttr){//遍历当前节点的所有属性
			String name=attr.getName();//属性名称
			String value=attr.getValue();//属性的值
			log.info("属性名称："+name+"属性值："+value);
		}
		
		//递归遍历当前节点所有的子节点
		List<Element> listElement=node.elements();//所有一级子节点的list
		for(Element e:listElement){//遍历所有一级子节点
			getNodes(e);//递归
		}
	}

}
