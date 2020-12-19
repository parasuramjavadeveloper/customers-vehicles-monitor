package se.altan.tracker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
/**
 * VehicleDTO with their properties
 *@author Parasuram
 */
public class VehicleDTO implements Serializable {
    private String vehicleId;
    private String regNo;
    private String status;

}
