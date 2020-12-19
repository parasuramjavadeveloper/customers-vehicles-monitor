package se.altan.tracker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.altan.tracker.response.Customer;
import se.altan.tracker.service.CustomerService;

@Slf4j
@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
/**
 * Rest controller to get all customers with vehicles and their statues which changes
 *  for every minute.
 *
 * @author Parasuram
 *
 */
public class CustomerController {

    private static final String NOT_FOUND = "Customers Not Found";

    @Autowired
    CustomerService customerService;


    /**
     * Get all the customers with its vehicles and their statuses
     *
     * @return <tt>ResponseEntity<Customer></tt> if the customers are available then returns Status OK
     * else it returns empty list and returns with status 404
     */
    @GetMapping("/customers")
    public ResponseEntity<Customer> getCustomers() {
        log.info("getAllCustomers");
        return ResponseEntity.ok(customerService.getCustomers());
    }


}
