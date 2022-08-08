package start.main.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "shop")
public class ShopVO {
	
	@Id
	@Column(name = "sIndex", nullable = false)
	private long sindex;
	
	@Column(name = "sName", nullable = false)
	private String sname;

	@Column(name = "sNumber", nullable = false)
	private String snumber;

	@Column(name = "sAddr", nullable = false)
	private String saddr;

	@Column(name = "sThum")
	private String sthum;
}
