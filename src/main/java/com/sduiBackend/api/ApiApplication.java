package com.sduiBackend.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
//@EnableJpaRepositories("com.sduiBackend.repository")
@EnableAsync
public class ApiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.out.println("Loaded DB URL: " + dotenv.get("NEON_DATABASE_URL"));
		System.setProperty("NEON_DATABASE_URL", dotenv.get("NEON_DATABASE_URL"));
		System.setProperty("DBUSER", dotenv.get("DBUSER"));
		System.setProperty("PASSWORD", dotenv.get("PASSWORD"));
		SpringApplication.run(ApiApplication.class, args);
	}

}
