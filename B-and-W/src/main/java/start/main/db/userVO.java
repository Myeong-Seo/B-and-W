package start.main.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor		
@NoArgsConstructor
@Entity
@Table(name="user")
public class userVO {
	@Id
	@Column(name = "u_id", nullable = false)
	private String u_id;
	@Column(name="u_pwd", nullable = false)
	private String u_pwd;
	@Column(name="u_name", nullable = false)
	private String u_name;
	@Column(name="u_addr", nullable = false)
	private String u_addr;
	@Column(name="u_number")
	private String u_number;
}
