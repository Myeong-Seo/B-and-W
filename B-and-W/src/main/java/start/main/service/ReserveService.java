package start.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.main.db.ReserveRepo;
import start.main.db.ReserveVO;

@Service
public class ReserveService {

	@Autowired
	ReserveRepo reserveRepo;
	
	public List<ReserveVO> findAll(){
		List<ReserveVO> shop = new ArrayList<>();
		reserveRepo.findAll().forEach(e -> shop.add(e));
		return shop;
	}
	
	public ReserveVO InsertShop(ReserveVO reserve) {
		return reserveRepo.save(reserve);
	}
	
//	public Optional<ReserveVO> findById(String name){
//		return reserveRepo.getById(name); 
//	}
	
	
	
}
