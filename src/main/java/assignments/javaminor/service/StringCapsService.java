package assignments.javaminor.service;

import assignments.javaminor.CrudRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("sm")
@Profile("caps")
public class StringCapsService extends StringModBean {

    public StringCapsService(CrudRepository repository) {
        super(repository);
    }

    @Override
    public String reverse(String inputString){
        return inputString.toUpperCase();
    }
}
