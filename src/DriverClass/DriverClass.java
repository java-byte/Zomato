package DriverClass;

import dao.CustomerRegisterDAO;
import dao.RestaurantRegisterDAO;
import models.Customer;
import models.Gender;
import models.Location;
import services.CustomerService;
import services.FoodKartService;
import services.LocationService;
import services.RestaurantService;

public class DriverClass {

    public static void main(String []s){

        FoodKartService foodKartService = FoodKartService.getInstance();
        CustomerService customerService = CustomerService.getInstance();
        RestaurantService restaurantService = RestaurantService.getInstance();
        LocationService locationService = LocationService.getInstance();

        Location btm = new Location("BTM", 123456);
        Location hsr = new Location("HSR", 234567);

        locationService.addLocation(btm);
        locationService.addLocation(hsr);

        Customer customer1 = new Customer("Pralov", Gender.MALE, 1234,hsr);
        Customer customer2 = new Customer("Nitesh", Gender.MALE, 2345,btm);
        Customer customer3 = new Customer("Vatsal", Gender.MALE, 3456,btm);

        customerService.registerUser(customer1);
        customerService.registerUser(customer2);
        customerService.registerUser(customer3);

        foodKartService.loginUser(1234);

        restaurantService.registerRestaurant("Food Count-1", "123456/234567", "NI Thali", 100, 5);
        restaurantService.registerRestaurant("Food Count-2", "123456", "Burger", 120, 3);
        restaurantService.registerRestaurant("Food Count-3", "234567", "SI Thali", 150, 1);

        foodKartService.loginUser(2345);

        System.out.println(FoodKartService.getLoggedInUser());
        System.out.println("Restaurant Details: "+ RestaurantRegisterDAO.getInstance().getRestaurantMap().toString());
        System.out.println("Customer Details: "+ CustomerRegisterDAO.getInstance().getCustomerMap().toString());
        System.out.println("");

        restaurantService.showRestaurant("price");
        foodKartService.placeOrder("Food Count-1", 2);

        foodKartService.placeOrder("Food Count-1", 7);

        foodKartService.createReview("Food Count-2", 3, "Good Food");
        foodKartService.createReview("Food Count-1", 5, "Good Food");

        restaurantService.showRestaurant("rating");

        foodKartService.loginUser(1234);
        restaurantService.updateQuantity("Food Count-2", 5);

        restaurantService.updateLocation("Food Count-2", "123456/234567");
    }
}
