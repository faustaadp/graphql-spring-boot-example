package xyz.itshark.play.graphqlspringboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GraphqlSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringBootApplication.class, args);
	}
}
