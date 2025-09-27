package jp.co.sss.cytech.web.controller;


import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import jp.co.sss.cytech.domain.entity.User; import jp.co.sss.cytech.domain.repository.UserRepository;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.GetMapping; import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
@Controller @RequestMapping("/user")
public class UserController {
    private final UserRepository users; public UserController(UserRepository users){ this.users = users; }
    @GetMapping("/mypage") public String mypage(Principal principal, Model model){
        User u = users.findByEmail(principal.getName()).orElseThrow(); model.addAttribute("user", u); return "user/mypage";
    }
}
