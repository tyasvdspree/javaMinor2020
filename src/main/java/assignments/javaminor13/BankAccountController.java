package assignments.javaminor13;

import assignments.javaminor13.exception.BankAccountNotFound;
import assignments.javaminor13.models.BankAccount;
import assignments.javaminor13.services.BankService;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAccount(@RequestBody BankAccount account){
        return service.createAccount(account);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccount(@PathVariable long id, @RequestBody BankAccount account){
        service.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Long id){
        service.deleteAccount(id);
    }
}
