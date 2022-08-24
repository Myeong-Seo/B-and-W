package start.main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import start.main.db.UserVO;
import start.main.service.UserService;

@RestController
@RequestMapping("/ch/users")
public class LoginRestController {

    private final UserService us;

    @Autowired
    public LoginRestController(UserService us) {
        this.us = us;
    }

    @PostMapping("/recover_user")
    public void recovery(@RequestParam("user_mail") String mail, HttpServletResponse response) {

        int result = us.recoverUserInfo(mail);
        if (result == 1) {
            String redirectUrl = "/recover_userinfo_splash";

            try {
                response.sendRedirect(redirectUrl);
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else {
            // 에러처리
        }

    }

    //회원 세션
    @PostMapping("/login_user")
    public void login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session, HttpServletResponse response) {
        UserVO user = us.userinfo(id);

        session.setAttribute("id", user.getUid());
        session.setAttribute("password", user.getUpwd());
        session.setAttribute("email", user.getUmail());
        session.setAttribute("number", user.getUnumber());

        String redirectUrl = "/main";
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //회원정보 세션
    @PostMapping("/modify_user")
    public void modify(
            @RequestParam("id") String id,
            @RequestParam("password1")
            String password1,
            @RequestParam("password2") String password2,
            @RequestParam("email") String email,
            @RequestParam("number") String number,
            HttpServletResponse response,
            HttpSession session) {
        UserVO user = us.userinfo(id);

        if (user.getUpwd().equals(password1)) {
            user.setUmail(email);
            user.setUnumber(number);
            session.setAttribute("id", user.getUid());
            session.setAttribute("password", user.getUpwd());
            session.setAttribute("email", user.getUmail());
            session.setAttribute("number", user.getUnumber());
            us.join_Member(user);
            session.invalidate();
        }
        String redirectUrl = "/main";
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @GetMapping("/test")
    public List<UserVO> test() {
        return us.findAll();
    }

  /*  @PostMapping("/sign1")
    public void join(
            @RequestParam("uname") String uname,
            @RequestParam("uid") String uid,
            @RequestParam("umail") String uemail,
            @RequestParam("unumber") String unumber,
            @RequestParam("uaddr1") String uaddr1,
            @RequestParam("uaddr2") String uaddr2,
            @RequestParam("upwd") String upwd,
            @RequestParam("upwdCheck") String upwdCheck,
            HttpServletResponse response) {


        UserVO member = new UserVO();

        member.setUname(uname);
        member.setUid(uid);
        member.setUmail(uemail);
        member.setUnumber(unumber);
        member.setUaddr1(uaddr1);
        member.setUaddr2(uaddr2);
        member.setUpwd(upwd);
        us.join_Member(member);

        String redirectUrl = "/main";
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    //회원가입
    @PostMapping("/sign")
    public ResponseEntity<String> signUp(UserVO user) {
        if (us.join_Member(user)) {
            return ResponseEntity.ok("s");
        } else {
            return ResponseEntity.badRequest().body("f");
        }
    }

    //아이디 중복체크
    @GetMapping("/{uid}")
    public ResponseEntity<String> checkId(@PathVariable String uid) {
        Optional<UserVO> user = us.findByuid(uid);
        if (!user.isPresent()) {
            return ResponseEntity.ok("s");
        } else if (user.isPresent()) {
            return ResponseEntity.ok("f");
        }
        return ResponseEntity.badRequest().body("x");
    }



}
