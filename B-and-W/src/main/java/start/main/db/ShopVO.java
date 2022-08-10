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
	@Column(name = "sindex", nullable = false)
	private long sindex;
	
	@Column(name = "sname", nullable = false)
	private String sname;

	@Column(name = "snumber", nullable = false)
	private String snumber;

	@Column(name = "saddr", nullable = false)
	private String saddr;

	@Column(name = "sthum")
	private String sthum;
}
