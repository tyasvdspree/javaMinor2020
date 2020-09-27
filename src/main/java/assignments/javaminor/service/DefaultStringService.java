package assignments.javaminor.service;

import assignments.javaminor.CrudRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class DefaultStringService extends StringModBean {

    public DefaultStringService(CrudRepository repository) {
        super(repository);
    }

    @Override
    public String reverse(String inputString){
        return new StringBuilder(inputString).reverse().toString();
    }
}
