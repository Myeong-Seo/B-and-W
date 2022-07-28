package start.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.main.db.ShopRepo;
import start.main.db.ShopVO;

@Service
public class ShopService {

	@Autowired
	ShopRepo shopRepo;
	
	public List<ShopVO> findAll(){
		List<ShopVO> shop = new ArrayList<>();
		shopRepo.findAll().forEach(e -> shop.add(e));
		return shop;
	}
	
	public ShopVO InsertShop(ShopVO shop) {
		return shopRepo.save(shop);
	}
	
	public Optional<ShopVO> findById(Long index){
		return shopRepo.findById(index); 
	}
	
	
	
	
}
