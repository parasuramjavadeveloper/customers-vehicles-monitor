package se.altan.tracker.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.altan.tracker.response.Customer;
import se.altan.tracker.service.CustomerService;
import se.altan.tracker.utils.Constants;

@Component
/**
 * Scheduler to refresh the vehicle statues of all customers
 * for every minute
 * @author Parasuram
 */
public class Scheduler {

    @Autowired
    CustomerService customerService;

    @Scheduled(cron = "0 */1 * * * *")
    public void customerVehiclesStatusRefresh() {
        Customer customerResponse = customerService.getCustomers();
        customerResponse.getCustomerList().forEach(customer -> {
            customer.getVehicleList().forEach(vehicle -> {
                if (vehicle.getStatus().equalsIgnoreCase(Constants.CONNECTED)) {
                    vehicle.setStatus(Constants.NOCONNECTION);
                } else {
                    vehicle.setStatus(Constants.CONNECTED);
                }
            });
        });
    }
}