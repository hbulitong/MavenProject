package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.listener.MessageListener;

public class KafkaMessageListener implements MessageListener<String,String>{
	private static Logger LOG = Logger.getLogger(KafkaMessageListener.class);
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
	    LOG.info("消费消息topic："+data.topic()+" value:"+data.value());
	    String topic = data.topic();
	    String content = data.value();
	    //可同时监听多个topic，根据不同topic处理不同的业务
	    if (topic.equals("topica")) {           
	        LOG.info("###############topic:"+topic+" value:"+content);
	    } else if (topic.equals("topicb")) {
	    	LOG.info("###############topic:"+topic+" value:"+content);
	    } 
	    
		
	}

}
