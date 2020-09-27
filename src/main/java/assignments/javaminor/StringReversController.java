package assignments.javaminor;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StringReversController {
    @Resource(name = "requestModBean")
    StringModBean requestModBean;

    @GetMapping("/stringrevers")
    public String handle(String input){

    }

    @GetMapping("/stringCounter")
    public String handle(String input){

    }
}
