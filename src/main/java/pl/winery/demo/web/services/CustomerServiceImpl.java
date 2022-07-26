package pl.winery.demo.web.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.winery.demo.web.model.CustomerDto;

import java.util.UUID;

/**
 * Created by mz 19.07.22
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .firstName("Marcin")
                .lastName("Zietek")
                .email("marcin@marcin.pl")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting a customer...");
    }
}
