package com.mimansa.rst.queuePOC;


import com.mimansa.rst.queuePOC.service.InitiateAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@RequiredArgsConstructor
@SpringBootApplication
public class RstMessagesS3ToQueueApplication {

	private final InitiateAppService initiateAppService;


	public Supplier<List<String>> startApp() {
		return () -> initiateAppService.startService();
	}

	public static void main(String[] args) {

		SpringApplication.run(RstMessagesS3ToQueueApplication.class, args);

	}


}
