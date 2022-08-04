package start.main.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor		
@NoArgsConstructor
@Entity
@Table(name="user")
public class UserVO {
	
	@Id
	@Column(name = "uId", nullable = false)
	private String uId;
	
	@Column(name="uPwd", nullable = false)
	private String uPwd;
	
	@Column(name="uName", nullable = false)
	private String uName;
	
	@Column(name="uAddr", nullable = false)
	private String uAddr;
	
	@Column(name="uNumber")
	private String uNumber;
	
	@OneToMany(mappedBy = "uId")
	private List<ReserveVO> ReserveVO = new ArrayList<ReserveVO>();
	
}
