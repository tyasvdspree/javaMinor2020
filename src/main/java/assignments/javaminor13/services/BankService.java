package assignments.javaminor13.services;

import assignments.javaminor13.data.BankAccountRepository;
import assignments.javaminor13.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private BankAccountRepository repository;

    public BankService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public List<BankAccount> getBankAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        repository.findAll().forEach(account -> bankAccounts.add(account));
        return bankAccounts;
    }

    public Optional<BankAccount> getBankAccount(Long id) {
        BankAccount account = repository.findOne(id);
        Optional<BankAccount> optAccount = Optional.ofNullable(account);
        return optAccount;
    }

    public Long createAccount(BankAccount bankAccount){
        repository.save(bankAccount);
        return bankAccount.getId();
    }

    public void updateAccount(BankAccount bankAccount){

    }

    public void deleteAccount(BankAccount account){
        repository.delete(account);
    }

    public void deleteAccount(Long id){
        repository.delete(id);
    }
}
