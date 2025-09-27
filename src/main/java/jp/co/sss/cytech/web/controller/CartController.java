package jp.co.sss.cytech.web.controller;


import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import jp.co.sss.cytech.domain.entity.Cart; import jp.co.sss.cytech.domain.repository.CartRepository; import jp.co.sss.cytech.domain.repository.UserRepository;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
import java.security.Principal; import java.util.List;
@Controller @RequestMapping("/cart")
public class CartController {
    private final CartRepository carts; private final UserRepository users;
    public CartController(CartRepository carts, UserRepository users){ this.carts=carts; this.users=users; }
    @GetMapping("/added") public String added(){ return "cart/added"; }
    @GetMapping public String index(Principal principal, Model model){
        Long uid = users.findByEmail(principal.getName()).orElseThrow().getId();
        List<Cart> list = carts.findByUser_Id(uid);
        int total = list.stream().mapToInt(c -> c.getProduct().getIncludeTax() * c.getQuantity()).sum();
        model.addAttribute("items", list); model.addAttribute("total", total); return "cart/index";
    }
    @PostMapping("/{cartId}/qty") public String updateQty(@PathVariable Long cartId, @RequestParam int quantity){
        Cart c = carts.findById(cartId).orElseThrow(); c.setQuantity(quantity); carts.save(c); return "redirect:/cart";
    }
    @PostMapping("/{cartId}/delete") public String delete(@PathVariable Long cartId){ carts.deleteById(cartId); return "redirect:/cart"; }
}
