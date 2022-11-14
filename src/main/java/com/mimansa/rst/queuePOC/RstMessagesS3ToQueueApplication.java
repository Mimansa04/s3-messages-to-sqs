package com.mimansa.rst.queuePOC;

import com.amazonaws.services.s3.model.S3Event;
import com.mimansa.rst.queuePOC.service.InitiateAppService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;
import java.util.function.Supplier;



@SpringBootApplication(
		exclude = {
				org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
				org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
				org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class
		}
)
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
	public Function<String,String> invoke(){
		initiateAppService.startService();
		return (String) -> null;
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
