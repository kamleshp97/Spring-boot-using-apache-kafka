package com.springboot.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.springboot.kafka.dto.Customer;

@Service
public class ProducerService {
	
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void produceMessage(String message) {
		for(int i = 1; i <= 10000; i++) {
		CompletableFuture<SendResult<String, Object>> future = template.send("kamlesh-2",message+i);
		future.whenComplete((result, exp) -> {
			if(result != null) {
				System.out.println(result.getRecordMetadata().offset());
			}
		});
	}
	}
	
	public void produce(Customer customer) {
			CompletableFuture<SendResult<String, Object>> future = template.send("kamlesh-customer",customer);
			System.out.println("KAMLESH");
			future.whenComplete((result, exp) -> {
				if(exp == null) {
					System.out.println(result.toString());
				}
				else {
					System.out.println("Something went wrong!!");
				}
			});
	}
}
