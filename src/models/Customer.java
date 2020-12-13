package models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

    private List<Orders> ordersList = new ArrayList<>();

    public Customer(String name, Gender gender, int phoneNumber, Location location){
        super(name, gender, phoneNumber, location);
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }


}
