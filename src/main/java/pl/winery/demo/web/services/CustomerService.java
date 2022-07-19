package pl.winery.demo.web.services;

import pl.winery.demo.web.model.CustomerDto;

import java.util.UUID;

/**
 * Created by mz 19.07.22
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

}
