package assignments.javaminor14.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountHolderNotFound extends RuntimeException {
    public AccountHolderNotFound() {
        new AccountHolderNotFound("Accountholder not found.");
    }

    public AccountHolderNotFound(String message) {
        super(message);
    }

    public AccountHolderNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountHolderNotFound(Throwable cause) {
        super(cause);
    }

    public AccountHolderNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
