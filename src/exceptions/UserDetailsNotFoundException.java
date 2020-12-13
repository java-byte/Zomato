package exceptions;

public class UserDetailsNotFoundException extends FoodKartException{
    public UserDetailsNotFoundException(String message) {
        super(message);
    }
}
