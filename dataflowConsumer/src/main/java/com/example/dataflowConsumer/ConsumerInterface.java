package com.example.dataflowConsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerInterface {

	@Input
	public SubscribableChannel consumerInput();
}
