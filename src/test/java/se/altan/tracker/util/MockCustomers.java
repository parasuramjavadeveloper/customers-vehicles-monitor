package se.altan.tracker.util;

import se.altan.tracker.dto.CustomerDTO;
import se.altan.tracker.repositories.VehicleRepository;
import se.altan.tracker.response.Customer;

import java.util.ArrayList;
import java.util.List;

public class MockCustomers {

    public static Customer mockCustomers() {
        Customer response = new Customer();
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
                .vehicleList(VehicleRepository.customerTwoVehicles()).build();
        customers.add(c3);
        response.setCustomerList(customers);

        return response;
    }

    public static List<CustomerDTO> emptyCustomers() {
        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
        return customers;
    }


}
