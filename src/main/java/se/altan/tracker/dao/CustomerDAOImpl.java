package se.altan.tracker.dao;

import org.springframework.stereotype.Repository;
import se.altan.tracker.dto.CustomerDTO;
import se.altan.tracker.repositories.CustomerRepository;

import java.util.List;

/**
 * DAO to get all the customers with vehicles and their statues from CustomerFactory
 *
 * @author Parasuram
 **/
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    /**
     * it returns list of customers with their vehicles to the UI and also brings vehicle
     * status which changes for every minute from scheduler
     *
     * @return List<CustomerDTO>
     */
    @Override
    public List<CustomerDTO> getCustomers() {
        return CustomerRepository.getCustomers();
    }
}
