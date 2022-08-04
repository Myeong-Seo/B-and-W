package start.main.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShopRepository extends JpaRepository<ShopVO, Long> {

	public ShopVO save(ShopVO shop);
	
	public Optional<ShopVO> findById(Long id);
	
	public Optional<ShopVO> findBysName(String name);
	
	public List<ShopVO> findAll();

}
