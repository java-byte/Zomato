package exceptions;

public class CustomerRegistrationFailedException extends FoodKartException {

    public CustomerRegistrationFailedException(String message) {
        super(message);
    }
}
