package com.example.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpmcController {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Value("${queueName}")
	public String queueName;
	
	@Value("${exchangeName}")
	public String exchangeName;

	@Value("${routingKey}")
	private String routingKey;

	@PostMapping("/greet/{name}")
	public String greet(@PathVariable String name){
		String string= "Hi : "+name;
		rabbitTemplate.convertAndSend(this.exchangeName,this.routingKey,string);
		System.out.println("greet : "+string);
		return string;
	}
	
	@GetMapping("/greet")
	public String receive(){
		
		String string = (String) rabbitTemplate.receiveAndConvert(this.queueName);
		System.out.println("receive : " +string);
		return string;
	}
}
