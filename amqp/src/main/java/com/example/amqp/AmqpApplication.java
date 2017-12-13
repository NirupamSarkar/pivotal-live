package com.example.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpApplication.class, args);
	}
	
	@Value("${queueName}")
	public String queueName;
	
	@Value("${exchangeName}")
	public String exchangeName;

	@Value("${routingKey}")
	private String routingKey;
	
	@Bean
	public Queue queue(){
		return new Queue(this.queueName);
	}
	
	@Bean
	public TopicExchange exchange(){
		return new TopicExchange(this.exchangeName);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(this.routingKey);
	}
	
	@Bean
	public RabbitTemplate rabbittemplate(ConnectionFactory connectionFatory ){
		//ConnectionFactory connectionFatory = new CachingConnectionFactory();
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFatory);
		rabbitTemplate.setExchange(this.exchangeName);
		rabbitTemplate.setQueue(this.queueName);
		return rabbitTemplate;
		
	}
}
