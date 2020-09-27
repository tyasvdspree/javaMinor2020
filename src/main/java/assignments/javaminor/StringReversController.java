package assignments.javaminor;

import assignments.javaminor.service.StringModBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StringReversController {

    StringModBean requestModBean;

    public StringReversController(StringModBean stringModBean){
        requestModBean = stringModBean;
    }

    @GetMapping("/stringrevers")
    public String reverse(@PathVariable String input){
        return requestModBean.reverse(input);
    }

    @GetMapping("/stringCounter")
    public Integer count(@PathVariable String input){
        return requestModBean.count(input);
    }
}
