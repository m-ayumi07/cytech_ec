package jp.co.sss.cytech.web.controller;

import jakarta.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.sss.cytech.domain.entity.User;
import jp.co.sss.cytech.domain.repository.UserRepository;
import jp.co.sss.cytech.web.dto.RegisterForm;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository users;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository users, PasswordEncoder encoder){
        this.users = users;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login"; 
    }

    @GetMapping("/register")
    public String register(@ModelAttribute RegisterForm f) {
        return "auth/register";
    }

    @PostMapping("/register/submit")
    public String submit(@Valid @ModelAttribute RegisterForm f,
                         BindingResult br,
                         RedirectAttributes ra) {
        if (!f.getPassword().equals(f.getConfirmPassword())) {
            br.rejectValue("confirmPassword", "mismatch", "確認用パスワードが一致しません");
        }
        if (br.hasErrors()) return "auth/register";

        User u = new User();
        u.setUserName(f.getUserName());
        u.setUserNameKana(f.getUserNameKana());
        u.setEmail(f.getEmail());
        u.setPhone(f.getPhone());
        u.setUserAddress(f.getUserAddress());
        u.setPassword(encoder.encode(f.getPassword()));
        users.save(u);

        ra.addFlashAttribute("registered", true);
        return "redirect:/auth/login";
    }
}
