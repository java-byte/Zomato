package services;

import dao.LocationDAO;
import dao.RestaurantRegisterDAO;
import exceptions.FoodKartException;
import exceptions.NoUserLoginException;
import exceptions.NotEnoughQuantityException;
import models.*;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantService {

    private static RestaurantService restaurantService;
    RestaurantRegisterDAO restaurantRegisterDAO = RestaurantRegisterDAO.getInstance();
    LocationDAO locationDAO = LocationDAO.getInstance();

    private RestaurantService(){}

    public static RestaurantService getInstance(){
        if(restaurantService==null){
            restaurantService = new RestaurantService();
        }
        return restaurantService;
    }

    public void registerRestaurant(String name, String locations, String dish, int price, int quantity) {

        if(FoodKartService.getLoggedInUser()==null){
            throw new NoUserLoginException("No user is logged In to perform this action");
        }
        // Get list of all restaurant location
        List<Integer> allZipCode = Arrays.stream(locations.split("/")).map(Integer::valueOf).collect(Collectors.toList());

        for(int zip: allZipCode){
            Location loc = locationDAO.getLocationFromZipCode(zip);
            Restaurant restaurant = new Restaurant(FoodKartService.getLoggedInUser(), name, loc, dish, price, quantity);
            restaurantRegisterDAO.registerRestaurant(restaurant);
        }
    }

    public void showRestaurant(String flag) {
        User user = FoodKartService.getLoggedInUser();
        if(user==null){
            throw new NoUserLoginException("No user loggedIn for which to show restaurant");
        }

        List<Restaurant> restaurantList = restaurantRegisterDAO.getRestaurantList(user.getLocation().getZipCode());

        // Filter Restaurant Based on Flag
        if(flag.equalsIgnoreCase("price")){
            Comparator<Restaurant> compareByPrice = (Restaurant r1, Restaurant r2) -> {
                return r1.getPrice().compareTo(r2.getPrice());
            };
            Collections.sort(restaurantList, compareByPrice.reversed());
            for(Restaurant res: restaurantList){
                if(res.getQuantity()>0){
                    System.out.println(res.getRestaurantName()+" "+res.getDish());
                }
            }
        }

        if(flag.equalsIgnoreCase("rating")){
            Comparator<Restaurant> compareByRating = (Restaurant r1, Restaurant r2) -> {
                return r1.getAvgReview().compareTo(r2.getAvgReview());
            };
            Collections.sort(restaurantList, compareByRating.reversed());
            for(Restaurant res: restaurantList){
                if(res.getQuantity()>0){
                    System.out.println(res.getRestaurantName()+" "+res.getDish());
                }
            }
        }

    }

    public void placeOrder(String restaurantName, int quantity) {

        User userDetail = FoodKartService.getLoggedInUser();

        List<Restaurant> restaurantList = restaurantRegisterDAO.getRestaurantList(userDetail.getLocation().getZipCode());

        Restaurant restaurant = restaurantList.stream()
                                                .filter(res -> res.getRestaurantName().equalsIgnoreCase(restaurantName))
                                                .findFirst()
                                                .get();
        if(restaurant.getQuantity()>=quantity){
            restaurant.setQuantity(restaurant.getQuantity() - quantity);
            System.out.println("Order Placed Successfully");
            Customer customer = (Customer)userDetail;
            customer.getOrdersList().add(new Orders(customer, restaurant, new Date(), quantity));
        }else{
            //throw new NotEnoughQuantityException("Not enough food to order !!");
            System.out.println("Not enough food to order !!");
        }

    }

    public Restaurant getRestaurantDetails(String restaurantName, int zipCode) {

        return restaurantRegisterDAO.getRestaurantList(zipCode).stream()
                                                            .filter(res -> res.getRestaurantName().equalsIgnoreCase(restaurantName))
                                                            .findFirst()
                                                            .get();

    }

    public void updateQuantity(String restaurantName, int quantity) {

        Restaurant restaurant = null;

        for(List<Restaurant> res : restaurantRegisterDAO.getRestaurantMap().values()){
            for(Restaurant res1: res){
                if(res1.getRestaurantName().equalsIgnoreCase(restaurantName)){
                    restaurant = res1;
                    break;
                }
            }
        }
        
        restaurant.setQuantity(quantity + restaurant.getQuantity());

        System.out.println(restaurant.getRestaurantName() + " "+restaurant.getLocation().getLocationName() + " "+restaurant.getDish()+"-"+restaurant.getQuantity());

    }

    public void updateLocation(String restaurantName, String location) {

    }
}
