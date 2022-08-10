package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.ShopVO;

public interface ShopRepository {
	ShopVO save(ShopVO shop);
	Optional<ShopVO> findById(Long sindex);
	Optional<ShopVO> findBysName(String sname);
	List<ShopVO> findAll();

}
