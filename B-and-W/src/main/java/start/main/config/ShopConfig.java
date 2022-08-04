package start.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import start.main.db.ShopRepository;
import start.main.service.ShopService;

@Configuration
public class ShopConfig {
	
	private ShopRepository shopRepository;
	
	@Autowired
	public ShopConfig(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}
	
	@Bean
	public ShopService shopService() {
		return new ShopService(shopRepository);
	}
	
}
