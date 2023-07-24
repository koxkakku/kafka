package com.sharad.learn.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharad.learn.springkafka.model.InterestDetails;
/**
 * @author koxkakku
 */
@Component
public class KafkaConsumer {
	@KafkaListener(topics="SI-INPUT")
	public void consume(String input) {
		ObjectMapper o = new ObjectMapper();
		;
		try {
			InterestDetails id = o.readValue(input, InterestDetails.class);
			System.out.println(String.format("simple interest for %s = %f",id,id.getPrincipal()*id.getRateOfInterest()*id.getTime()/100 ));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
