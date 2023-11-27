package com.bnt.KafkaDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.KafkaDemo.producer.KafkaProducer;

@RestController
public class KafkaProducerController {
	
	@Autowired
	private KafkaProducer kafkaProducer;

	/*
	 * public KafkaProducerController(KafkaProducer kafkaProducer) { super();
	 * this.kafkaProducer = kafkaProducer; }
	 */
	@GetMapping("/sendMessage")
	public ResponseEntity<String> produceMessage(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
     return ResponseEntity.ok("Message sent to kafka topic");	
     }

}
