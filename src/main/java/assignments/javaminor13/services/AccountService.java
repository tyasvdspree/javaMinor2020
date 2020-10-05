package assignments.javaminor13.services;

import assignments.javaminor13.data.AccountHolderRepository;
import assignments.javaminor13.data.BankAccountRepository;
import assignments.javaminor13.models.AccountHolder;
import assignments.javaminor13.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountHolderRepository repository;
    private BankAccountRepository bankAccountRepository;

    public AccountService(AccountHolderRepository repository, BankAccountRepository bankAccountRepository) {
        this.repository = repository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<AccountHolder> getAccountHolders() {
        List<AccountHolder> accountHolders = new ArrayList<>();
        repository.findAll().forEach(account -> accountHolders.add(account));
        return accountHolders;
    }

    public Optional<AccountHolder> getAccountHolder(Long id) {
        AccountHolder account = repository.findOne(id);
        Optional<AccountHolder> optAccount = Optional.ofNullable(account);
        return optAccount;
    }

    public List<BankAccount> getBankAccounts(long id) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccount -> {
                if(bankAccount.getAccountHolders().contains(bankAccount)){
                    bankAccounts.add(bankAccount);
                }});
        return bankAccounts;
    }

    public Long createAccount(AccountHolder accountHolder){
        repository.save(accountHolder);
        return accountHolder.getId();
    }

    public void updateAccount(AccountHolder accountHolder){
        repository.update(accountHolder);
    }

    public void deleteAccount(AccountHolder accountHolder){
        repository.delete(accountHolder);
    }

    public void deleteAccount(Long id){
        repository.delete(id);
    }
}
