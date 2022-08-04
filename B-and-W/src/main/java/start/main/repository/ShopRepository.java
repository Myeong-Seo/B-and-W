package start.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.main.db.ShopVO;

public interface ShopRepository {
	ShopVO save(ShopVO shop);
	Optional<ShopVO> findById(Long sIndex);
	Optional<ShopVO> findBysName(String sName);
	List<ShopVO> findAll();

}
