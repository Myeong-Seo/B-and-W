package start.main.repository;

import java.util.List;
import java.util.Optional;

import start.main.db.ShopVO;

public interface ShopRepository {

	ShopVO save(ShopVO shop);
	Optional<ShopVO> findBysindex(Long sindex);
	Optional<ShopVO> findBysname(String sname);
	List<ShopVO> findAll();

}
