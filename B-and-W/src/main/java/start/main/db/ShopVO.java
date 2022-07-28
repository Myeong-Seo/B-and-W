package start.main.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity(name = "shop")
public class ShopVO {
	
	@Id
	@Column(name = "s_index", nullable = false)
	private long s_index;
	
	@Column(name = "s_name", nullable = false)
	private String s_name;

	@Column(name = "s_number", nullable = false)
	private String s_number;

	@Column(name = "s_addr", nullable = false)
	private String s_addr;
	
	@Column(name = "s_thum")
	private String s_thum;
	
}
