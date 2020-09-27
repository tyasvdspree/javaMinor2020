package assignments.javaminor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;


public class ScopeConfig{

    @Bean
    @RequestScope
    public StringModBean requestModBean(){
        return new StringModBean();
    }
}
