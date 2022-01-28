package com.example.demo_amigocode.student;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args->{
			Student raj = new Student("Raj Sharma", LocalDate.of(2001, Month.MARCH, 24), "sharmaraj22211@gmail.com");
			Student alex = new Student("Alex", LocalDate.of(2011, Month.MARCH, 24), "sharmaraj22211@gmail.com");
			repository.saveAll(
						List.of(raj, alex)
					);
		};
	}
}
