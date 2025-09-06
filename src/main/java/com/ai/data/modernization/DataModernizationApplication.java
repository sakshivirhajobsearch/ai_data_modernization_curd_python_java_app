package com.ai.data.modernization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// GET http://localhost:8080/api/data → get all
// GET http://localhost:8080/api/data/{id} → get by ID
// POST http://localhost:8080/api/data → create
// PUT http://localhost:8080/api/data/{id} → update
// DELETE http://localhost:8080/api/data/{id} → delete

@SpringBootApplication
public class DataModernizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataModernizationApplication.class, args);
		System.out.println("✅ Data Modernization Java Backend running on http://localhost:8080/");
	}
}