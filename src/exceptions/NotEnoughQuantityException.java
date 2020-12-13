package exceptions;

public class NotEnoughQuantityException extends FoodKartException{
    public NotEnoughQuantityException(String message) {
        super(message);
    }
}
