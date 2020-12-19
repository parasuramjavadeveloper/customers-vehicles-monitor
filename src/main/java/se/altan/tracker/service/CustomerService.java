package se.altan.tracker.service;


import se.altan.tracker.response.Customer;

/**
 * Service to get all customers with vehicles and their statues from dao layer
 *
 * @author Parasuram
 **/
@FunctionalInterface
public interface CustomerService {

    Customer getCustomers();

}
