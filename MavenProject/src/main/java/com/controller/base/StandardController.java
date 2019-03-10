package com.controller.base;

import javax.servlet.http.HttpServletRequest;

import common.bean.BusContext;
import common.bean.IBusContext;

public abstract class StandardController {
	//数据总线
	protected ThreadLocal<IBusContext> context=new ThreadLocal<IBusContext>();
	private ThreadLocal<String> SessionID=new ThreadLocal<String>();
	
	public String execute(HttpServletRequest request){
		try{
			this.SessionID.set(request.getSession().getId());
			initContext(request);
			this.context.get().jsonToXml();
			realExecute(request);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "";
	}
	//初始化context
	public void initContext(HttpServletRequest request){
		this.context.set(new BusContext(request));
	}
	//抽象方法，由具体的每个controller实现
	public abstract void realExecute(HttpServletRequest request) throws Exception;
}
