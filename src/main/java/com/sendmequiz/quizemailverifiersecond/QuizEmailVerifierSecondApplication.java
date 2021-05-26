package com.sendmequiz.quizemailverifiersecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuizEmailVerifierSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizEmailVerifierSecondApplication.class, args);
	}

}
