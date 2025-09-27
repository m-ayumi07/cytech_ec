package jp.co.sss.cytech.web.advice;
import jp.co.sss.cytech.domain.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@Component @ControllerAdvice
public class GlobalModelAttributes {
    private final CategoryRepository categories;
    public GlobalModelAttributes(CategoryRepository categories){ this.categories = categories; }
    @ModelAttribute("categories") public Object categories(){ return categories.findAll(); }
}
