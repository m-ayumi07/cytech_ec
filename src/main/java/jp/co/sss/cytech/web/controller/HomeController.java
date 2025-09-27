package jp.co.sss.cytech.web.controller;
import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class HomeController { @GetMapping("/") public String index(){ return "index"; } }
