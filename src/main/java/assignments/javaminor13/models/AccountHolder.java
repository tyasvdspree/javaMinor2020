package assignments.javaminor13.models;

import java.util.Random;

public class AccountHolder {

    private static Random rdm = new Random();

    private Long id;
    private String firstname;
    private String lastname;

    public AccountHolder(String firstname, String lastname) {
        this.id = rdm.nextLong();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Boolean isEmpty(){
        if (!(firstname == null || firstname.isEmpty())
                && !(lastname == null || lastname.isEmpty()) ){
            return false;
        }
        return true;
    }
}
