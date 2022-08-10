package start.main.service;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import start.main.db.UserVO;
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
		user1.setUaddr1("오산");
		user1.setUaddr2("부산동");
		user1.setUmail("1235@naver.com");
		
		System.out.println(user1.getUid());
		
		us.join_Member(user1);
		
		UserVO findUser = us.findOne(user1.getUname()).get();
		Assertions.assertThat(user1.getUname()).isEqualTo(findUser.getUname());
		
		System.out.println(findUser.getUname());
		
	}
	
	
}
