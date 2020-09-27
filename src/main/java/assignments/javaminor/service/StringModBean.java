package assignments.javaminor.service;

import assignments.javaminor.CrudRepository;

public abstract class StringModBean {

    private CrudRepository _repository;

    public StringModBean(CrudRepository repository){
        _repository = repository;
    }

    public abstract String reverse(String inputString);

    public Integer count(String inputString) {
        int pos = _repository.find(inputString);
        if (pos > -1) {
            return pos;
        } else {
            int wordCount = inputString.split(" ").length;
            _repository.save(inputString, wordCount);
            return wordCount;
        }
    }
}
