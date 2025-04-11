package com.dotcom.crud_user;
import com.dotcom.crud_user.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudUserApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudUserApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args -> {
//			for (int i = 0; i < 50; i++) {
//				Faker faker = new Faker();
//				var user = User.builder()
//						.name(faker.name().name())
//						.email(faker.name().firstName() + i + faker.name().lastName() + "@contact.com")
//						.build();
//				userRepository.save(user);
//			}
		};
	}

}
