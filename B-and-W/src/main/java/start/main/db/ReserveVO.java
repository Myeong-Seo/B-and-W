package start.main.db;

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

	@Id
	@Column
	private Long sIndex;

	//1:1? 1:다? 다:1? 다:다?
	@ManyToOne
	@JoinColumn(name = "uId")
	private UserVO uId;


	@Column(name = "sName", nullable = false)
	private String sName;

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
