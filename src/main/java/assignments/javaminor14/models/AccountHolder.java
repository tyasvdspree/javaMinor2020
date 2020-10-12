package assignments.javaminor14.models;

import assignments.javaminor14.enums.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Accountholder")
public class AccountHolder extends BaseEntity{

    private String firstname;
    private String lastname;
    @Enumerated
    private Gender gender;
    @Embedded
    private assignments.javaminor14.models.Address Address;

    @ManyToMany(
            mappedBy = "accountHolders"
    )
    private List<BankAccount> accounts = new ArrayList<>();

    public AccountHolder() {}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public Boolean isEmpty(){
        if (!(firstname == null || firstname.isEmpty())
                && !(lastname == null || lastname.isEmpty()) ){
            return false;
        }
        return true;
    }
}
