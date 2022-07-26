package start.main.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "reserve")
public class ReserveVO {

	@Id
	@Column
	private Long sindex;

	//1:1? 1:다? 다:1? 다:다?
	@ManyToOne
	@JoinColumn(name = "uid")
	private UserVO uid;

	@Column(name = "sname", nullable = false)
	private String sname;

	@Column(name = "reservice", nullable = false)
	private String reservice;

	@Column(name = "snumber", nullable = false)
	private String snumber;

	@Column(name = "saddr", nullable = false)
	private String saddr;
	
	//private String date_time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	@Column(name = "retime", nullable = false)
	private String retime;
	
	@Column(name = "recondition", nullable = false)
	private String recondition;
	
}
