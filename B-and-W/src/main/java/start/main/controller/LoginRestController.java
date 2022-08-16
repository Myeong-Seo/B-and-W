package start.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String recovery(@RequestParam("user_mail") String mail) {
        int result = us.recoverUserInfo(mail);

        return "redirect:/";
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
