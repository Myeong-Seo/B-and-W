package start.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import start.main.repository.SDJReserveRepository;

import start.main.service.ReserveService;

@Configuration
public class ReserveConfig {
	
	private SDJReserveRepository reserveRepository;
	
	@Autowired
	public ReserveConfig(SDJReserveRepository reserveRepository) {
		this.reserveRepository = reserveRepository;
	}
	
	@Bean
	public ReserveService reserveService() {
		return new ReserveService(reserveRepository);
	}
	
}
