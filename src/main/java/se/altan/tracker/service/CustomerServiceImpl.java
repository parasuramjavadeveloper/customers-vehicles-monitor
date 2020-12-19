package se.altan.tracker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.altan.tracker.dao.CustomerDAO;
import se.altan.tracker.exception.ResourceNotFoundException;
import se.altan.tracker.response.Customer;

/**
 * Service to get all customers with vehicles and their statues from dao layer
 *
 * @author Parasuram
 **/
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
   private CustomerDAO customerDAO;

    @Autowired
   private ObjectFactory<Customer> customerObjectFactory;

    /**
     * it returns list of customers with their vehicles from DAO Layer
     *
     * @return List<CustomerDTO>
     */
    @Override
    public Customer getCustomers() {
        Customer response = customerObjectFactory.getObject();
        if (customerDAO.getCustomers().isEmpty()) {
            throw new ResourceNotFoundException("No Customers Found");
        }
        response.setCustomerList(customerDAO.getCustomers());
        return response;
    }
}
