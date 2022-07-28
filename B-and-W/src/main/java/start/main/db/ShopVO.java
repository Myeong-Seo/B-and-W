package start.main.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Column(name = "s_index")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String s_index;
	
	@Column(name = "s_name")
	private String s_name;
	
	@Column(name = "s_number")
	private String s_number;
	
	@Column(name = "s_addr")
	private String s_addr;
	
	@Column(name = "s_thum")
	private String s_thum;
	
}
