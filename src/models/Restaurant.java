package models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {

    private User owner;
    private String restaurantName;
    private Location location;
    private String dish;
    private Integer price;
    private int quantity;
    private Integer avgReview;
    private int totalReview;
    private int totalReviewCount;

    public Restaurant(User owner, String restaurantName, Location location, String dish, int price, int quantity) {
        this.restaurantName = restaurantName;
        this.dish = dish;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
        this.owner = owner;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Integer getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvgReview() {
        return getTotalReview()/getTotalReviewCount();
    }

    public void setAvgReview(Integer avgReview) {
        this.avgReview = avgReview;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }

    public int getTotalReviewCount() {
        return totalReviewCount;
    }

    public void setTotalReviewCount(int totalReviewCount) {
        this.totalReviewCount = totalReviewCount;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "owner=" + owner.getName() +
                ", restaurantName='" + restaurantName + '\'' +
                ", location=" + location.getLocationName() +
                ", dish='" + dish + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
