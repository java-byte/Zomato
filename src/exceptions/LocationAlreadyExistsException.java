package exceptions;

public class LocationAlreadyExistsException extends FoodKartException{
    public LocationAlreadyExistsException(String message) {
        super(message);
    }
}
