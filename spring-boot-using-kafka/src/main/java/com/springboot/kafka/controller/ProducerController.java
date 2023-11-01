package com.springboot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.dto.Customer;
import com.springboot.kafka.service.ProducerService;

@RestController
@RequestMapping("/producer-app")
public class ProducerController {
	@Autowired
	private ProducerService producerService;

	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable("message") String msg){
		try {
		producerService.produceMessage(msg);
		return ResponseEntity.ok("Message sent Successfully!!");
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/publish")
	public void publish(@RequestBody Customer customer){
		System.out.println(customer.toString());
		try {
			producerService.produce(customer);
			System.out.println("Message sent Successfully!!");
		}
		catch(Exception ex) {
			System.out.println("Message sent Failed!!");
		}
	}
}
