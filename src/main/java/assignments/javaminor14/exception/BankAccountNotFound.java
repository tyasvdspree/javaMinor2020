package assignments.javaminor14.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankAccountNotFound extends RuntimeException {
    public BankAccountNotFound() {
        new BankAccountNotFound("bankaccount not found.");
    }

    public BankAccountNotFound(String message) {
        super(message);
    }

    public BankAccountNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAccountNotFound(Throwable cause) {
        super(cause);
    }

    public BankAccountNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
