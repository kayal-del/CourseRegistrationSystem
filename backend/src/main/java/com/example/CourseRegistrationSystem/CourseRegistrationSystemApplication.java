package com.example.CourseRegistrationSystem;

import com.example.CourseRegistrationSystem.Model.Course;
import com.example.CourseRegistrationSystem.Repository.CourseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseRegistrationSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepo repo) {
		return args -> {
			if (repo.count() == 0) {
				repo.save(new Course("CS101", "Java Essentials", "John Doe", "6"));
				repo.save(new Course("CS102", "Python for ML", "Jane Smith", "8"));
				repo.save(new Course("CS103", "Spring Boot", "Alex Brown", "4"));
			}
		};
	}
}
