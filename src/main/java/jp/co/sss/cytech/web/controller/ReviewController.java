package jp.co.sss.cytech.web.controller;
import jp.co.sss.cytech.domain.entity.*; import jp.co.sss.cytech.domain.repository.*; import jp.co.sss.cytech.web.dto.ReviewForm;
import jakarta.validation.Valid; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.validation.*; import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/review")
public class ReviewController {
    private final ReviewRepository reviews; private final ProductRepository products; private final UserRepository users;
    public ReviewController(ReviewRepository r, ProductRepository p, UserRepository u){ this.reviews=r; this.products=p; this.users=u; }
    @GetMapping("/{productId}/new") public String form(@PathVariable Long productId, @ModelAttribute ReviewForm form, Model model){
        model.addAttribute("productId", productId); return "review/form";
    }
    @PostMapping("/{productId}/submit") public String submit(@PathVariable Long productId, @Valid @ModelAttribute ReviewForm f, BindingResult br, java.security.Principal principal){
        if(br.hasErrors()) return "review/form";
        Review rv = new Review(); rv.setProduct(products.getReferenceById(productId)); rv.setUser(users.findByEmail(principal.getName()).orElseThrow());
        rv.setDummyUserName(f.getUserName()); rv.setReviewImgPath(f.getImagePath()==null? "" : f.getImagePath()); rv.setRating(f.getRating()); rv.setComment(f.getComment()); reviews.save(rv);
        return "redirect:/product/" + productId;
    }
}
