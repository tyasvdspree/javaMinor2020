package assignments.javaminor14.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "Bankaccount")
public class BankAccount extends BaseEntity{

    @NotNull(message = "IBAN cannot be null")
    private String IBAN;
    private Long saldo;
    @NotEmpty(message = "Must have at least one accountHolder")
    @ManyToMany
    @JoinTable(
            name="bankaccount_holders",
            joinColumns = @JoinColumn(name="accountId"),
            inverseJoinColumns = @JoinColumn(name = "holderId")
    )
    private List<AccountHolder> accountHolders;
    private boolean isBlocked = false;

    public BankAccount() {

    }

    public @NotNull(message = "Id cannot be null") long getId() {
        return this.getId();
    }

    public String getIBAN() {
        return IBAN;
    }

    public Long getSaldo() {
        return saldo;
    }

    public List<AccountHolder> getAccountHolders() {
        return accountHolders;
    }

    public void blockAccount(){
        this.isBlocked = true;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean isEmpty(){
        if(!(IBAN == null || IBAN.isEmpty())){
            return false;
        }
        return true;
    }
}
