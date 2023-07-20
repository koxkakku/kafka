package com.sharad.learn.springkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author koxkakku
 */
@Component
public class KafkaConsumer {
	@KafkaListener(topics={"my-topic","hello-greeting"})
	public void consume(String name) {
		System.out.println(name);
	}
}
