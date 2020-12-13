package dao;

import exceptions.NoRestaurantExistsException;
import models.Restaurant;

import java.util.*;

public class RestaurantRegisterDAO {

    private static RestaurantRegisterDAO restaurantRegisterDAO;

    private Map<Integer, List<Restaurant>> restaurantMap = new HashMap<>();

    private RestaurantRegisterDAO(){}

    public static RestaurantRegisterDAO getInstance(){
        if(restaurantRegisterDAO==null){
            restaurantRegisterDAO = new RestaurantRegisterDAO();
        }
        return restaurantRegisterDAO;
    }


    public void registerRestaurant(Restaurant restaurant) {

        if(restaurantMap.containsKey(restaurant.getLocation().getZipCode())){
            restaurantMap.get(restaurant.getLocation().getZipCode()).add(restaurant);
        }
        else{
            restaurantMap.put(restaurant.getLocation().getZipCode(), new ArrayList<Restaurant>(Arrays.asList(restaurant)));
            }
    }

    public Map<Integer, List<Restaurant>> getRestaurantMap() {
        return restaurantMap;
    }

    public void setRestaurantMap(Map<Integer, List<Restaurant>> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public List<Restaurant> getRestaurantList(int zipCode) {
        if(!restaurantMap.containsKey(zipCode)){
            throw new NoRestaurantExistsException("No restaurant exists in logged in user zipCode");
        }
        return restaurantMap.get(zipCode);
    }
}
