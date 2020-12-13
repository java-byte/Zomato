package services;

import dao.CustomerRegisterDAO;
import models.Customer;
import models.User;

public class CustomerService {

    private static CustomerService customerService;

    CustomerRegisterDAO customerRegisterDAO = CustomerRegisterDAO.getInstance();

    private CustomerService(){}

    public static CustomerService getInstance(){
        if(customerService ==null){
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void registerUser(Customer customer) {
        customerRegisterDAO.registerCustomer(customer);
    }

    public User getUserDetails(int phoneNumber) {

        return customerRegisterDAO.getUserDetails(phoneNumber);
    }
}
