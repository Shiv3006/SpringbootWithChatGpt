package com.bnt.KafkaDemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bnt.KafkaDemo.constant.KafkaConstant;

@Service
public class KafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = KafkaConstant.TOPIC_NAME, groupId = KafkaConstant.GROUP_ID)
	public void consume(String message) {
		LOGGER.info(String.format("Message received", message));
	}

}
