package com.example.dataflowConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(ConsumerInterface.class)
@SpringBootApplication
public class DataflowConsumerApplication {

	@StreamListener("consumerInput")
	public void listener(Message message){
		String string = message.getPayload().toString();
		System.out.println("listener : "+string);
		
	}
	public static void main(String[] args) {
		SpringApplication.run(DataflowConsumerApplication.class, args);
	}
}
