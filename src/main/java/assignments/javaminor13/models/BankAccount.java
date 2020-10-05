package assignments.javaminor13.models;

import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.Random;

public class BankAccount{

    private static Random rdm = new Random();

    private Long id;
    @NotNull(message = "IBAN cannot be null")
    private String IBAN;
    private Long saldo;
    @NotEmpty(message = "Must have at least one accountHolder")
    private ArrayList<AccountHolder> accountHolders;
    private boolean isBlocked = false;

    public BankAccount(String IBAN, ArrayList<AccountHolder> accountHolders) {
        this.id = rdm.nextLong();
        this.IBAN = IBAN;
        this.accountHolders = accountHolders;
    }

    public BankAccount(String IBAN, Long saldo, ArrayList<AccountHolder> accountHolders) {
        this.id = rdm.nextLong();
        this.IBAN = IBAN;
        this.saldo = saldo;
        this.accountHolders = accountHolders;
    }

    public @NotNull(message = "Id cannot be null") Long getId() {
        return id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Long getSaldo() {
        return saldo;
    }

    public ArrayList<AccountHolder> getAccountHolders() {
        return accountHolders;
    }

    public void blockAccount(){
        this.isBlocked = true;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean isEmpty(){
        if(id != null
                && !(IBAN == null || IBAN.isEmpty())){
            return false;
        }
        return true;
    }
}
