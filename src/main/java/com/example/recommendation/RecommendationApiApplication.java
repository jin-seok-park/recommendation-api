package com.example.recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RecommendationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendationApiApplication.class, args);
    }

}
