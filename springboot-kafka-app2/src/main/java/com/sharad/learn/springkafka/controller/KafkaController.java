package com.sharad.learn.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharad.learn.springkafka.model.InterestDetails;

@RestController
@RequestMapping("/business")
public class KafkaController {
	@Autowired
	private KafkaTemplate<String, InterestDetails> kafkaTemplate;
	
	@PostMapping("/calculate")
	public void calculate(@RequestBody InterestDetails input) {
		kafkaTemplate.send("SI-INPUT", input);
	}

}