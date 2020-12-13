package exceptions;

public class NoRestaurantExistsException extends FoodKartException{
    public NoRestaurantExistsException(String message) {
        super(message);
    }
}
