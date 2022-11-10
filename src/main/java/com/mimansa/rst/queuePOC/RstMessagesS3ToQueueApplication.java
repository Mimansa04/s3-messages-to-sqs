package com.mimansa.rst.queuePOC;

import com.mimansa.rst.queuePOC.service.InitiateAppService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.function.Supplier;


@SpringBootApplication
public class RstMessagesS3ToQueueApplication {

	private final InitiateAppService initiateAppService;

	@Autowired
	public RstMessagesS3ToQueueApplication(InitiateAppService initiateAppService) {
		this.initiateAppService = initiateAppService;
	}

//	@Bean
//	@Override
//	public void startApp() {
//		initiateAppService.startService();
//	}


	@Bean
	public Supplier<String> invoke(){
		initiateAppService.startService();
		return () -> null;
	}

//	@Bean
//	public Consumer<S3Event> invoke(){
//
//		return (S3Event) -> {initiateAppService.startService();};
//
//	}
	public static void main(String[] args) {

		SpringApplication.run(RstMessagesS3ToQueueApplication.class, args);

	}
}
