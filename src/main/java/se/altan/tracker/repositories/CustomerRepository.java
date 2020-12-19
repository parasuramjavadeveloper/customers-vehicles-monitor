package se.altan.tracker.repositories;

import org.springframework.stereotype.Repository;
import se.altan.tracker.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * it creates and produces the list of customers.
 *
 * @author Parasuram
 */
@Repository
public class CustomerRepository {

    public static List<CustomerDTO> getCustomers() {
        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
        CustomerDTO c1 = CustomerDTO.builder()
                .address("Cementvägen 8")
                .city("Södertälje").customerName("Kalles Grustransporter AB").pinCode("111 11")
                .vehicleList(VehicleRepository.customerOneVehicles()).build();

        customers.add(c1);

        CustomerDTO c2 = CustomerDTO.builder()
                .address("Balkvägen 12")
                .city("Stockholm").customerName("Johans Bulk AB").pinCode("222 22")
                .vehicleList(VehicleRepository.customerTwoVehicles()).build();
        customers.add(c2);

        CustomerDTO c3 = CustomerDTO.builder()
                .address("Budgetvägen 1")
                .city("Uppsala").customerName("Haralds Värdetransporter AB").pinCode("333 33")
                .vehicleList(VehicleRepository.customerThreeVehicles()).build();
        customers.add(c3);


        return customers;
    }
}
