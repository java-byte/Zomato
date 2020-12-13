package services;

import exceptions.NoUserLoginException;
import exceptions.UserDetailsNotFoundException;
import models.Restaurant;
import models.User;

public class FoodKartService {

    private static FoodKartService foodKartService;

    CustomerService customerService = CustomerService.getInstance();
    RestaurantService restaurantService = RestaurantService.getInstance();

    private static User loggedInUser;

    private FoodKartService(){}

    public static FoodKartService getInstance(){
        if(foodKartService==null){
            foodKartService = new FoodKartService();
        }
        return foodKartService;
    }

    public void loginUser(int phoneNumber){

        User userDetails = customerService.getUserDetails(phoneNumber);

        if(userDetails==null){
            throw new UserDetailsNotFoundException("Unable to fetch user details while login");
        }

        setLoggedInUser(userDetails);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        FoodKartService.loggedInUser = loggedInUser;
    }


    public void placeOrder(String restaurantName, int quantity) {
        if(getLoggedInUser()==null){
            throw new NoUserLoginException("No User Login to place order.");
        }
        restaurantService.placeOrder(restaurantName, quantity);
    }

    public void createReview(String restaurantName, int rating, String comment) {

        /* TODO: As of now user is able to review restaurant who have zipcode same as user zipCode
        *   We need to extends this -> like he can review only those restaurant from where he has placed orders.
        */
        if(FoodKartService.getLoggedInUser()==null){
            throw new NoUserLoginException("Please login before giving review");
        }
        User userDetails = customerService.getUserDetails(FoodKartService.getLoggedInUser().getPhoneNumber());
        Restaurant restaurant = restaurantService.getRestaurantDetails(restaurantName, userDetails.getLocation().getZipCode());
        restaurant.setTotalReview(restaurant.getTotalReview() + rating);
        restaurant.setTotalReviewCount(restaurant.getTotalReviewCount() + 1);

        // TODO: Save review in DB.
    }
}
