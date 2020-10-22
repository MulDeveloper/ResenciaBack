package com.resencia.backoffice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ResenciaBackoffice {

	public static void main(String[] args) {
		SpringApplication.run(ResenciaBackoffice.class, args);
	}

}
