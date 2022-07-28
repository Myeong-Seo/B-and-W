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
	private Long s_index;
	
	//1:1? 1:다? 다:1? 다:다?
	@ManyToOne
	@JoinColumn(name = "u_id")
	private UserVO u_id;
	//private UesrVO u_id;
	
	@Column(name = "s_name", nullable = false)
	private String s_name;
	//private ShopVO s_name;
	
	@Column(name = "re_service", nullable = false)
	private String re_service;
	
	@Column(name = "s_number", nullable = false)
	private String s_number;
	
	@Column(name = "s_addr", nullable = false)
	private String s_addr;
	
	//private String date_time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	@Column(name = "re_time", nullable = false)
	private String re_time;
	
	@Column(name = "re_condition", nullable = false)
	private String re_condition;
	
}
