package assignments.javaminor14.web;

import assignments.javaminor14.exception.AccountHolderNotFound;
import assignments.javaminor14.models.AccountHolder;
import assignments.javaminor14.models.BankAccount;
import assignments.javaminor14.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("AccountHolder")
public class AccountHolderController {

    private AccountService service;

    public AccountHolderController(AccountService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAccountHolders(){
        return service.getAccountHolders();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder getAccountHolder(@PathVariable long id){
        Optional<AccountHolder> optionalBankAccount = service.getAccountHolder(id);
        return optionalBankAccount.orElseThrow(AccountHolderNotFound::new);
    }

    @GetMapping("/{id}/accounts/")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> getBankAccounts(@PathVariable long id) {
        return service.getBankAccounts(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAccountHolder(@RequestBody AccountHolder accountHolder){
        return service.createAccount(accountHolder);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountHolder(@PathVariable long id, @RequestBody AccountHolder accountHolder){
        service.updateAccount(accountHolder);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(@PathVariable long id){
        service.getAccountHolder(id).orElseThrow(AccountHolderNotFound::new);
        service.deleteAccount(id);
    }
}
