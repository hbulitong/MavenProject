package com.service.getui;

import java.util.Map;

import common.bean.RequestBody;

public interface IPushMsgService {
	public Map<String,Object> pushToSingle(RequestBody requsetBody);
	public Map<String,Object> pushToArray(RequestBody requsetBody);
}
