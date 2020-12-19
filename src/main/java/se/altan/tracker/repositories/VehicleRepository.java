package se.altan.tracker.repositories;

import org.springframework.stereotype.Repository;
import se.altan.tracker.dto.VehicleDTO;
import se.altan.tracker.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * it produces list of vehicles for different customers.
 *
 * @author Parasuram
 */
@Repository
public class VehicleRepository {
    static List<VehicleDTO> customerOneVehicles;
    static List<VehicleDTO> customerTwoVehicles;
    static List<VehicleDTO> customerThreeVehicles;

    public static List<VehicleDTO> customerOneVehicles() {
        if (customerOneVehicles == null) {
            customerOneVehicles = new ArrayList<VehicleDTO>();
            VehicleDTO v1 = VehicleDTO.builder()
                    .vehicleId("YS2R4X20005399401")
                    .regNo("ABC123")
                    .status(Constants.CONNECTED).build();
            customerOneVehicles.add(v1);

            VehicleDTO v2 = VehicleDTO.builder()
                    .vehicleId("VLUR4X20009093588")
                    .regNo("DEF456")
                    .status(Constants.NOCONNECTION).build();
            customerOneVehicles.add(v2);

            VehicleDTO v3 = VehicleDTO.builder()
                    .vehicleId("VLUR4X20009048066")
                    .regNo("GHI789")
                    .status(Constants.NOCONNECTION).build();
            customerOneVehicles.add(v3);
        }


        return customerOneVehicles;
    }

    public static List<VehicleDTO> customerTwoVehicles() {
        if (customerTwoVehicles == null) {
            customerTwoVehicles = new ArrayList<VehicleDTO>();
            VehicleDTO v1 = VehicleDTO.builder()
                    .vehicleId("YS2R4X20005388011")
                    .regNo("JKL012")
                    .status(Constants.CONNECTED).build();
            customerTwoVehicles.add(v1);

            VehicleDTO v2 = VehicleDTO.builder()
                    .vehicleId("YS2R4X20005387949")
                    .regNo("MNO345")
                    .status(Constants.CONNECTED).build();
            customerTwoVehicles.add(v2);
        }

        return customerTwoVehicles;
    }

    public static List<VehicleDTO> customerThreeVehicles() {
        if (customerThreeVehicles == null) {
            customerThreeVehicles = new ArrayList<VehicleDTO>();
            VehicleDTO v1 = VehicleDTO.builder()
                    .vehicleId("YS2R4X20005387765")
                    .regNo("PQR678")
                    .status(Constants.NOCONNECTION).build();
            customerThreeVehicles.add(v1);

            VehicleDTO v2 = VehicleDTO.builder()
                    .vehicleId("YS2R4X20005387055")
                    .regNo("STU901")
                    .status(Constants.NOCONNECTION).build();
            customerThreeVehicles.add(v2);
        }

        return customerThreeVehicles;
    }
}
