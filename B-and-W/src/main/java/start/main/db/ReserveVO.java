package start.main.db;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

=======
>>>>>>> refs/heads/PMS
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity(name = "reserve")
public class ReserveVO {
<<<<<<< HEAD

	@Column(name = "u_id")
	private String u_id;
=======
	
	@Id
	@Column
	private Long sIndex;
	
	//1:1? 1:다? 다:1? 다:다?
	@ManyToOne
	@JoinColumn(name = "uId")
	private UserVO uId;
	//private UesrVO u_id;
>>>>>>> refs/heads/PMS
	
	@Column(name = "sName", nullable = false)
	private String sName;
	//private ShopVO s_name;
	
	@Column(name = "reService", nullable = false)
	private String reService;
	
	@Column(name = "sNumber", nullable = false)
	private String sNumber;
	
	@Column(name = "sAddr", nullable = false)
	private String sAddr;
	
	//private String date_time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	@Column(name = "reTime", nullable = false)
	private String reTime;
	
	@Column(name = "reCondition", nullable = false)
	private String reCondition;
	
}
