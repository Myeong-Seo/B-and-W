package start.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import start.main.repository.UserRepository;

@Configuration
public class SpringConfig {

	private final UserRepository userRepository;

	@Autowired
	public SpringConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Bean
	public UserService userService() {
		return new UserService(userRepository);
	}
}
