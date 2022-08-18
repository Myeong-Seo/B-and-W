package start.main.service;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import start.main.db.UserVO;
import start.main.repository.UserRepository;

@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void join_Member(UserVO member) {
		userRepository.save(member);
	}
	
	public List<UserVO> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<UserVO> findByuid(String id){
		return userRepository.findByuid(id);
	}
	
	public Optional<UserVO> findOne(String name) {
		return userRepository.findByuname(name);
	}
	
	public Optional<UserVO> findOneByMail(String mail) {
		return userRepository.findByumail(mail);
	}
	
	//회원정보
	public UserVO userinfo(String id) {
		if(findByuid(id).isPresent()) {
			UserVO user = findByuid(id).get();
			return user;
		}
		else {
			return null;
		}
	}
	
	public String login(String uid, String upwd, HttpServletRequest request) {
		Optional<UserVO> user = userRepository.findByuid(uid);
		HttpSession session = request.getSession();
		if(user.isPresent()) {
			if(user.get().getUid().equals(uid) && user.get().getUpwd().equals(upwd)) {
				session.setAttribute("user", user);
				return "s";
			}
			else {
				return "f";
			}
		}
		return "e";
	}
	
	@Transactional
	public boolean userinfoo(HttpSession session, UserVO user) {
		String uid = user.getUid();
		Optional<UserVO> before = userRepository.findByuid(uid);
		if(before.isPresent()) {
			if(user.getUpwd() == null) {
				user.setUpwd(before.get().getUpwd());
			}
		}
		UserVO after = userRepository.save(user);
		if(after != null) {
			//협의 후 살리거나 지움
			session.removeAttribute("user");
			session.setAttribute("user", after);
			return true;
		}
		return false;
	}
	
	/*
	//로그아웃
	public boolean logout(HttpSession session) {
		if(session.getAttribute("id") != null) {
			session.invalidate();
			return true;
		}
		return false;
	}
	*/
	
	// 메일용
	@Value("${spring.mail.username}")
	String from;
	
	public int recoverUserInfo(String mail) {
		
		if(findOneByMail(mail).isPresent()) {
			UserVO user = findOneByMail(mail).get();
			
			String subject = "B & W 아이디 / 비밀번호 찾기";
			StringBuffer sb = new StringBuffer();
			sb.append("<html><body>");
	 		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	 		sb.append("<h1>" + "아이디 / 비밀번호 찾기 결과" + "</h1><br>");
	 		sb.append("<br><br>");
	 		sb.append("<p>" + "아이디 : " + user.getUid() + "<br>");
	 		sb.append("비밀번호 : " + user.getUpwd() + "</p>");
	 		sb.append("</body></html>");
	 		String contents = sb.toString();
			
			try {
				MimeMessage mime = javaMailSender.createMimeMessage();
				MimeMessageHelper mimeHelper = new MimeMessageHelper(mime, true, "UTF-8");
				
				mimeHelper.setSubject(subject);
				mimeHelper.setFrom(from);
				mimeHelper.setTo(user.getUmail());
				mimeHelper.setText(contents, true);
				
				javaMailSender.send(mime);
				return 1;
			} catch (MessagingException e) {
				
				e.printStackTrace();
				return -1;
			}
		}
		else {
			return 0;
		}
	}
}
