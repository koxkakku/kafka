package com.sharad.learn.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharad.learn.springkafka.model.Numbers;

/**
 * @author koxkakku
 */
@Component
public class KafkaConsumer {
	@KafkaListener(topics="CALCULATOR")
	public void consume(String input) {
		
		ObjectMapper o = new ObjectMapper();
		;
		try {
			System.out.println(input);
			Numbers in = o.readValue(input, Numbers.class);
			
			System.out.println(in);
			double result = 0d;
			switch(in.getOperation()) {
			case "ADD": result = in.getNumber1()+in.getNumber2();
						break;
			case "SUBTRACT": result = in.getNumber1()-in.getNumber2();
								break;
			case "MULTIPLY": result = in.getNumber1()*in.getNumber2();
								break;
			case "DEVIDE": result = in.getNumber1()/in.getNumber2();
							break;
			}
			System.out.println(String.format("Result of %s = %f",in,result));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
