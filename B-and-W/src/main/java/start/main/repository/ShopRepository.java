package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.ShopVO;

public interface ShopRepository {
	ShopVO save(ShopVO shop);
	Optional<ShopVO> findById(Long sIndex);
	Optional<ShopVO> findBysname(String sName);
	List<ShopVO> findAll();

}
