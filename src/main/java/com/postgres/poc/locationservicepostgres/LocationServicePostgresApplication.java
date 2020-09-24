package com.postgres.poc.locationservicepostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LocationServicePostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationServicePostgresApplication.class, args);
	}

}
