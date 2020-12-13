package exceptions;

import services.FoodKartService;

public class NoUserLoginException extends FoodKartException {
    public NoUserLoginException(String message) {
        super(message);
    }
}
