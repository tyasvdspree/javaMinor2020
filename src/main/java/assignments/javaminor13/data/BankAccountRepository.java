package assignments.javaminor13.data;

import assignments.javaminor13.models.BankAccount;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class BankAccountRepository {

    public static final HashMap<Long, BankAccount> bankAccounts = new HashMap<>();

    public void save(BankAccount bankAccount) {
        bankAccounts.putIfAbsent(bankAccount.getId(),bankAccount);
    }

    public BankAccount findOne(Long primaryKey) {
        return bankAccounts.getOrDefault(primaryKey,null);
    }

    public Iterable<BankAccount> findAll() {
        List<BankAccount> accounts = new ArrayList<>();
        bankAccounts.forEach((aLong, bankAccount) -> accounts.add(bankAccount));
        return accounts;
    }

    public Long count() {
        return (long)bankAccounts.size();
    }

    public void update(BankAccount bankAccount){
        bankAccounts.put(bankAccount.getId(),bankAccount);
    }

    public void delete(BankAccount bankAccount) {
        delete(bankAccount.getId());
    }

    public void delete(Long id) {
        bankAccounts.remove(id);
    }

    public boolean exists(Long id) {
        BankAccount account = bankAccounts.get(id);
        if (account.isEmpty()){
            return false;
        }
        return true;
    }

}
