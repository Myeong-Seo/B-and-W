package start.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import start.main.db.ReserveVO;
import start.main.repository.SDJReserveRepository;

@Transactional
public class ReserveService {

	@Autowired
	SDJReserveRepository reserveRepository;

	public ReserveService(SDJReserveRepository reserveRepository) {
		this.reserveRepository = reserveRepository;
	}

	public List<ReserveVO> findAll(){
		List<ReserveVO> shop = new ArrayList<>();
		reserveRepository.findAll().forEach(e -> shop.add(e));
		return shop;
	}

	public ReserveVO InsertShop(ReserveVO reserve) {
		return reserveRepository.save(reserve);
	}

//	public Optional<ReserveVO> findById(String name){
//		return reserveRepo.getById(name); 
//	}
	
	
	
}
