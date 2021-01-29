package com.escolaalf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.escolaalf.resources")
public class EscolaAlfApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaAlfApplication.class, args);
	}

}
