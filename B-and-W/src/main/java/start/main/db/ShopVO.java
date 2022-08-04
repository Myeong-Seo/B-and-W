package start.main.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@Column(name = "sIndex", nullable = false)
	private long sIndex;
	
	@Column(name = "sName", nullable = false)
	private String sName;

	@Column(name = "sNumber", nullable = false)
	private String sNumber;

	@Column(name = "sAddr", nullable = false)
	private String sAddr;

	@Column(name = "sThum")
	private String sThum;

}
