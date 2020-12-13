package models;

import java.util.Date;

public class Orders {

    private Customer customerName;
    private Restaurant restaurantName;
    private Date orderDate;
    private int orderNumber;
    private int quantity;
    private static int orderCount=0;

    public Orders(Customer customerName, Restaurant restaurantName, Date orderDate, int quantity) {
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.orderDate = orderDate;
        orderCount+=1;
        this.orderNumber = orderCount;
        this.quantity = quantity;
    }

    public Customer getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Customer customerName) {
        this.customerName = customerName;
    }

    public Restaurant getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(Restaurant restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
