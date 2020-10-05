package assignments.javaminor13.data;

import assignments.javaminor13.models.AccountHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class AccountHolderRepository {

    public static final HashMap<Long, AccountHolder> accountHolders = new HashMap<>();

    public void save(AccountHolder accountHolder) {
        accountHolders.putIfAbsent(accountHolder.getId(),accountHolder);
    }

    public AccountHolder findOne(Long primaryKey) {
        return accountHolders.getOrDefault(primaryKey,null);
    }

    public Iterable<AccountHolder> findAll() {
        List<AccountHolder> accounts = new ArrayList<>();
        accountHolders.forEach((aLong, accountHolder) -> accounts.add(accountHolder));
        return accounts;
    }

    public Long count() {
        return (long) accountHolders.size();
    }

    public void update(AccountHolder accountHolder){
        accountHolders.put(accountHolder.getId(),accountHolder);
    }

    public void delete(AccountHolder accountHolder) {
        delete(accountHolder.getId());
    }

    public void delete(Long id) {
        accountHolders.remove(id);
    }

    public boolean exists(Long id) {
        AccountHolder account = accountHolders.get(id);
        if (account.isEmpty()){
            return false;
        }
        return true;
    }

}
