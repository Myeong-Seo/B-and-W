package start.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import start.main.repository.UserRepository;
import start.main.service.UserService;

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
