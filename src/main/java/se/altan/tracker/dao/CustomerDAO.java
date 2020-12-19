package se.altan.tracker.dao;

import se.altan.tracker.dto.CustomerDTO;

import java.util.List;

@FunctionalInterface
/**
 * DAO to get all the customers with vehicles and their statues from CustomerFactory
 *
 * @author Parasuram
 **/
public interface CustomerDAO {


    List<CustomerDTO> getCustomers();

}
