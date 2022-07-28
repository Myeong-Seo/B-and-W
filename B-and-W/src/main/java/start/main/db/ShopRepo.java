package start.main.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<ShopVO, Long> {
	
	public Optional<ShopVO> findById(Long index);

}
