package se.altan.tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
/**
 * customerDTO with vehicleList
 *@author Parasuram
 *
 */
public class CustomerDTO implements Serializable {
    private String customerName;
    private String address;
    private String pinCode;
    private String city;
    private List<VehicleDTO> vehicleList;


}
