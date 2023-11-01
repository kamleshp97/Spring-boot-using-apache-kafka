package com.springboot.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.kafkaconsumer.dto.Customer;

@Service
public class ConsumerService {
	
	Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics = "kamlesh-customer", groupId = "kamlesh-p")
	public void consume(Customer customer) {
		System.out.println(customer.toString());
		logger.info("Consumer = ", customer);
	}
	
	
/*
	@KafkaListener(topics = "kamlesh-2", groupId = "kamleshp")
	public void consume1(String message) {
		System.out.println(message);
		logger.info("Consumer = ", message);
	}
	@KafkaListener(topics = "kamlesh-2", groupId = "kamleshp")
	public void consume2(String message) {
		System.out.println(message);
		logger.info("Consumer = ", message);
	}
	@KafkaListener(topics = "kamlesh-2", groupId = "kamleshp")
	public void consume3(String message) {
		System.out.println(message);
		logger.info("Consumer = ", message);
	}
	@KafkaListener(topics = "kamlesh-2", groupId = "kamleshp")
	public void consume4(String message) {
		System.out.println(message);
		logger.info("Consumer = ", message);
	}
	
*/
}
