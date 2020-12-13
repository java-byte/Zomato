package dao;

import exceptions.CustomerRegistrationFailedException;
import exceptions.UserDetailsNotFoundException;
import models.Customer;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class CustomerRegisterDAO {

    private static CustomerRegisterDAO customerRegisterDAO;

    private Map<Integer, Customer> customerMap = new HashMap<>();

    private CustomerRegisterDAO(){}

    public static CustomerRegisterDAO getInstance(){
        if(customerRegisterDAO==null){
            customerRegisterDAO = new CustomerRegisterDAO();
        }
        return customerRegisterDAO;
    }

    public void registerCustomer(Customer customer) {
        if(customerMap.containsKey(customer.getPhoneNumber())){
            throw new CustomerRegistrationFailedException("Customer already exists with phone number. Please change phone number and register again");
        }

        customerMap.put(customer.getPhoneNumber(), customer);
    }

    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public User getUserDetails(int phoneNumber) {
        if(customerMap.containsKey(phoneNumber)){
            return customerMap.get(phoneNumber);
        }
        throw new UserDetailsNotFoundException("Unable to find user details with this phone numner while login");
    }
}
