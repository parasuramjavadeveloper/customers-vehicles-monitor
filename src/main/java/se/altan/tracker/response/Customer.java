package se.altan.tracker.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import se.altan.tracker.dto.CustomerDTO;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Component
public class Customer {
    private List<CustomerDTO> customerList = Collections.emptyList();
}
