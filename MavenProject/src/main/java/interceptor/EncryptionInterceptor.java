package interceptor;

import java.io.BufferedReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import common.ParamConstant;

/**
 * 拦截器：加解密
 * @author Administrator
 *
 */
public class EncryptionInterceptor implements HandlerInterceptor {
	
	private Logger log=Logger.getLogger(this.getClass());
	public EncryptionInterceptor(){
		log.info("拦截请求加解密开始！！！");
	}
	
	/**
	 * afterCompletion方法是在DispatcherServlet进行视图的渲染之后执行调用，主要是进行一些资源清理等工作
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 执行controller之后执行
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 执行controller之前执行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		//流只能读取一次，可以将数据存储起来，初始化到数据总线
		StringBuffer sf =new StringBuffer();
		BufferedReader br;
		br=request.getReader();
		String cache;
		while((cache=br.readLine())!=null){
			sf.append(cache);
		}
		log.info("原文："+sf.toString());
//		Enumeration<String> param=request.getParameterNames();
//		Map<String,Object> map=new HashMap<String,Object>();
//		while(param.hasMoreElements()){
//			String name=(String)param.nextElement();
//			map.put(name, request.getParameter(name));
//		}
//		JSONObject json=JSONObject.fromObject(map);   //map转json
		request.setAttribute(ParamConstant.REQUESTPARAM, sf.toString());
		log.info("入参集合:"+sf.toString());
		return true;
	}

}
