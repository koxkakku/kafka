package com.sharad.learn.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@PostMapping("/publish")
	public void publishName(@RequestBody String name) {
		kafkaTemplate.send("my-topic",name);
		kafkaTemplate.send("hello-greeting",String.format("Hello, %s", name));
	}
}
