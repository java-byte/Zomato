package exceptions;

public class FoodKartException extends RuntimeException{

    public FoodKartException(String message){
        System.out.println(message);
    }

}
