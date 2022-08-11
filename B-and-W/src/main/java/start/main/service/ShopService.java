package start.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import start.main.db.ShopVO;
import start.main.repository.SDJShopRepository;

@Transactional
public class ShopService {

	@Autowired
	private final SDJShopRepository shopRepository;
	
	public ShopService(SDJShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}

	public ShopVO save(ShopVO shop) {
		return shopRepository.save(shop);
	}
	
	public List<ShopVO> findAll(){
		List<ShopVO> shop = new ArrayList<>();
		shopRepository.findAll().forEach(e -> shop.add(e));
		return shop;
	}
	
	//public Optional<ShopVO> findByName(String name){
	//	return 
	//}
	
	public Optional<ShopVO> findById(Long sindex){
		return shopRepository.findById(sindex); 
	}
	
	
	
}
