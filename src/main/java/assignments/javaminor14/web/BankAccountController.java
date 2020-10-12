package assignments.javaminor14.web;

import assignments.javaminor14.exception.BankAccountNotFound;
import assignments.javaminor14.models.BankAccount;
import assignments.javaminor14.services.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("BankAccount")
public class BankAccountController {

    private BankService service;

    public BankAccountController(BankService bankService) {
        this.service = bankService;
    }

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> getBankAccounts(){
        return service.getBankAccounts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BankAccount getBankAccount(@PathVariable Long id){
        Optional<BankAccount> optionalBankAccount = service.getBankAccount(id);
        return optionalBankAccount.orElseThrow(BankAccountNotFound::new);
    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAccount(@RequestBody BankAccount account){
        return service.createAccount(account);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateAccount(@PathVariable long id, @RequestBody BankAccount account){
        service.updateAccount(account);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void blockAccount(@PathVariable long id){
        BankAccount bankAccount = service.getBankAccount(id).orElseThrow(BankAccountNotFound::new);
        service.blockAccount(bankAccount);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteBankAccount(@PathVariable Long id){
        BankAccount bankAccount = service.getBankAccount(id).orElseThrow(BankAccountNotFound::new);
        service.deleteAccount(bankAccount);
    }
}
