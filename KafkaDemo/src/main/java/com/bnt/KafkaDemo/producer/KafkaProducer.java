package com.bnt.KafkaDemo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bnt.KafkaDemo.constant.KafkaConstant;

@Service
public class KafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkatemplate;

	public void sendMessage(String message) {
		logger.info("Message Sent-> %s", message);
		kafkatemplate.send(KafkaConstant.TOPIC_NAME, message);
	}

}
