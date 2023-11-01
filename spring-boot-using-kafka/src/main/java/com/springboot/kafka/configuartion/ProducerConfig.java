package com.springboot.kafka.configuartion;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

	@Bean
	NewTopic newTopic() {
		return new NewTopic("kamlesh-customer", 3, (short) 1);
	}
}
