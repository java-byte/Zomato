package models;

public class Review {
    private User customer;
    private Restaurant restaurant;
    private int rating;
    private String comments="";

    public Review(User customer, Restaurant restaurant, int rating) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.rating = rating;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
