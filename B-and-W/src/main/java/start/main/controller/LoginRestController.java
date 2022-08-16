package start.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import start.main.db.UserVO;
import start.main.service.UserService;

@RestController
public class LoginRestController {

    private final UserService us;

    @Autowired
    public LoginRestController(UserService us) {
        this.us = us;
    }

    @PostMapping("/recover_user")
    public void recovery(@RequestParam("user_mail") String mail, HttpServletResponse response) {

        int result = us.recoverUserInfo(mail);
        if(result == 1) {
            String redirectUrl = "/recover_userinfo_splash";

            try {
                response.sendRedirect(redirectUrl);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        else {
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
    public void modify(@RequestParam("id") String id, @RequestParam("password1") String password1, @RequestParam("password2") String password2, @RequestParam("email") String email, @RequestParam("number") String number, HttpServletResponse response, HttpSession session) {
        UserVO user = us.userinfo(id);

        if(user.getUpwd().equals(password1)) {
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

    @PostMapping("/signup")
    public void join(@RequestParam("id") String uid,
                     @RequestParam("email") String uemail,
                     @RequestParam("name") String uname,
                     @RequestParam("phone") String unumber,
                     @RequestParam("address") String uaddr1,
                     @RequestParam("address_detail") String uaddr2,
                     @RequestParam("password") String upwd) {


        UserVO member = new UserVO();
        member.setUid(uid);
        member.setUmail(uemail);
        member.setUname(uname);
        member.setUnumber(unumber);
        member.setUaddr1(uaddr1);
        member.setUaddr2(uaddr2);
        member.setUpwd(upwd);
        us.join_Member(member);

        return;
    }
}
