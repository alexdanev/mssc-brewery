package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getById(UUID customerId) {
        return CustomerDto
                .builder()
                .id(customerId)
                .name("Test Name")
                .build();
    }
}
