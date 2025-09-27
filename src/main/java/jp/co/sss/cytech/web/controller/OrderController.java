package jp.co.sss.cytech.web.controller;
import jp.co.sss.cytech.domain.entity.*; import jp.co.sss.cytech.domain.repository.*; import jp.co.sss.cytech.web.dto.OrderEntryForm;
import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*; import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal; import java.util.List;
@Controller @RequestMapping("/order")
public class OrderController {
    private final CartRepository carts; private final UserRepository users; private final OrderRepository orders; private final OrderItemRepository orderItems;
    public OrderController(CartRepository carts, UserRepository users, OrderRepository orders, OrderItemRepository orderItems){
        this.carts=carts; this.users=users; this.orders=orders; this.orderItems=orderItems; }
    @GetMapping("/entry") public String entry(@ModelAttribute OrderEntryForm form, Principal principal, Model model){
        Long uid = users.findByEmail(principal.getName()).orElseThrow().getId();
        List<Cart> list = carts.findByUser_Id(uid);
        int total = list.stream().mapToInt(c->c.getProduct().getIncludeTax()*c.getQuantity()).sum();
        model.addAttribute("items", list); model.addAttribute("total", total); return "order/entry";
    }
    @PostMapping("/confirm") public String confirm(@Valid @ModelAttribute OrderEntryForm form, BindingResult br, Principal principal, Model model){
        if(br.hasErrors()) return "order/entry";
        Long uid = users.findByEmail(principal.getName()).orElseThrow().getId();
        List<Cart> list = carts.findByUser_Id(uid);
        int total = list.stream().mapToInt(c->c.getProduct().getIncludeTax()*c.getQuantity()).sum();
        model.addAttribute("form", form); model.addAttribute("items", list); model.addAttribute("total", total); return "order/confirm";
    }
    @PostMapping("/complete") public String complete(@ModelAttribute OrderEntryForm form, Principal principal, RedirectAttributes ra){
        Long uid = users.findByEmail(principal.getName()).orElseThrow().getId();
        List<Cart> list = carts.findByUser_Id(uid);
        int total = list.stream().mapToInt(c->c.getProduct().getIncludeTax()*c.getQuantity()).sum();
        Order o = new Order(); o.setUser(users.getReferenceById(uid)); o.setTotalAmount(total); o.setStatus("CONFIRMED"); orders.save(o);
        list.forEach(c -> { OrderItem oi = new OrderItem(); oi.setOrder(o); oi.setProduct(c.getProduct()); oi.setQuantity(c.getQuantity()); oi.setPrice(c.getProduct().getIncludeTax()*c.getQuantity()); orderItems.save(oi); });
        carts.deleteAll(list); ra.addFlashAttribute("orderId", o.getId()); return "redirect:/order/complete";
    }
    @GetMapping("/complete") public String completePage(){ return "order/complete"; }
}
