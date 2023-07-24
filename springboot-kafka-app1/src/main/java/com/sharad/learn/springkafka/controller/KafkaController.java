package com.sharad.learn.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharad.learn.springkafka.model.Numbers;
/**
 * @author koxkakku
 */
@RestController
@RequestMapping("/math")
public class KafkaController {
	
	
	
	@Autowired
	private KafkaTemplate<String, Numbers> kafkaTemplate;
	
	@PostMapping("/calculate")
	public void calculate(@RequestBody Numbers input) {
		kafkaTemplate.send("CALCULATOR", input);
	}

}
