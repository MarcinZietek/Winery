package pl.winery.demo.web.services;

import pl.winery.demo.web.model.CustomerDto;

import java.util.UUID;

/**
 * Created by mz 19.07.22
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
    CustomerDto saveNewCustomer(CustomerDto customerDto);
    void updateCustomer(UUID customerId, CustomerDto customerDto);
    void deleteCustomerById(UUID customerId);
}
