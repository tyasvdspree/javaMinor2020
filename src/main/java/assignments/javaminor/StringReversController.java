package assignments.javaminor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StringReversController {

    @GetMapping("/stringrevers")
    public String handle(String input){
        return new StringBuilder(input).reverse().toString();
    }
}
