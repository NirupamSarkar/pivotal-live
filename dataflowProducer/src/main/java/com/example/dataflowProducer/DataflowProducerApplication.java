package com.example.dataflowProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication
public class DataflowProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataflowProducerApplication.class, args);
	}
}
