package start.main.service;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import start.main.repository.UserRepository;

@SpringBootTest
@Transactional
public class UserServiceTest {

	@Autowired UserService us;
	@Autowired UserRepository ur;
	
	@Test
	public void save() {
		UserVO user1 = new UserVO();
		user1.setUid("test1");
		user1.setUpwd("123");
		user1.setUname("아무개");
		user1.setUaddr("오산");
		
		System.out.println(user1.getUid());
		
		us.join_Member(user1);
		
		UserVO findUser = us.findOne(user1.getUname()).get();
		Assertions.assertThat(user1.getUname()).isEqualTo(findUser.getUname());
		
		System.out.println(findUser.getUname());
		
	}
	
	
}
