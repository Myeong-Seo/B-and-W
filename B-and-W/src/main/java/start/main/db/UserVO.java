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
@Table(name = "user")
public class UserVO {
	// Upload
	//변수명  소문자
	@Id
	@Column(name = "uid", nullable = false)
	private String uid;

	@Column(name="upwd", nullable = false)
	private String upwd;

	@Column(name="uname", nullable = false)
	private String uname;

	@Column(name="uaddr1", nullable = false)
	private String uaddr1;
	
	@Column(name="uaddr2", nullable = false)
	private String uaddr2;
	
	@Column(name="umail", nullable = false)
	private String umail;
	
	@Column(name="unumber")
	private String unumber;
	
	@OneToMany(mappedBy = "uid")
	private List<ReserveVO> ReserveVO = new ArrayList<ReserveVO>();

}
