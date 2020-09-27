package assignments.javaminor;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CrudRepository{

    HashMap<String, Integer> _knownText = new HashMap<>();

    public void save(String text, Integer wordCount){
        _knownText.putIfAbsent(text, wordCount);
    }

    public Integer find(String text){
        Integer res = _knownText.getOrDefault(text, -1);

        return res;
    }
}

