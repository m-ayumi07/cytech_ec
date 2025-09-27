package jp.co.sss.cytech.web.controller;


import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import jp.co.sss.cytech.domain.entity.*; import jp.co.sss.cytech.domain.repository.*;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
import java.security.Principal; import java.util.*;
@Controller @RequestMapping("/product")
public class ProductController {
    private final ProductRepository products; private final CompanyRepository companies;
    private final CategoryRepository categories; private final ReviewRepository reviews;
    private final CartRepository carts; private final UserRepository users;
    public ProductController(ProductRepository p, CompanyRepository c, CategoryRepository g, ReviewRepository r, CartRepository cart, UserRepository u){
        this.products=p; this.companies=c; this.categories=g; this.reviews=r; this.carts=cart; this.users=u; }
    @GetMapping("/list") public String list(@RequestParam Optional<String> q, @RequestParam Optional<String> company,
                                           @RequestParam Optional<Long> categoryId, Model model){
        List<Product> result;
        if(company.isPresent() && !company.get().isBlank()) result = products.searchByCompany(company.get());
        else if(q.isPresent() && !q.get().isBlank()) result = products.findByProductNameContainingIgnoreCase(q.get());
        else if(categoryId.isPresent()) result = products.findByCategory_Id(categoryId.get());
        else result = products.findAll();
        model.addAttribute("products", result); model.addAttribute("companies", companies.findAll()); return "product/list";
    }
    @GetMapping("/{id}") public String detail(@PathVariable Long id, Model model){
        Product p = products.findById(id).orElseThrow(); model.addAttribute("p", p);
        model.addAttribute("reviews", reviews.findByProduct_IdOrderByCreatedAtDesc(id)); return "product/detail";
    }
    @PostMapping("/{id}/add-to-cart") public String addToCart(@PathVariable Long id, @RequestParam int quantity, Principal principal){
        Long uid = users.findByEmail(principal.getName()).orElseThrow().getId();
        Cart c = carts.findByUser_IdAndProduct_Id(uid, id).orElse(new Cart());
        c.setUser(users.getReferenceById(uid)); c.setProduct(products.getReferenceById(id));
        c.setQuantity(c.getId()==null ? quantity : c.getQuantity()+quantity); carts.save(c); return "redirect:/cart/added";
    }
    @PostMapping("/{id}/buy-now") public String buyNow(@PathVariable Long id, @RequestParam int quantity, Principal principal){
        Long uid = users.findByEmail(principal.getName()).orElseThrow().getId();
        Cart c = new Cart(); c.setUser(users.getReferenceById(uid)); c.setProduct(products.getReferenceById(id)); c.setQuantity(quantity);
        carts.save(c); return "redirect:/order/entry";
    }
}
