package com.alexandre.crudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.alexandre.crudapi.config.property.CrudApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(CrudApiProperty.class)
public class CrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}

}
