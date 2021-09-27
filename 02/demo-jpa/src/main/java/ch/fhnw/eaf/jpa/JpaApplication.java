package ch.fhnw.eaf.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Autowired
	MovieService service;
	
	@Bean
	CommandLineRunner run() {
		return args -> {
			Long id = service.saveNewMovie("James Bond: No Time To Die", LocalDate.of(2021, 9, 30));
			System.out.println(id);
			service.rentMovie(id);
		};
	}

}
