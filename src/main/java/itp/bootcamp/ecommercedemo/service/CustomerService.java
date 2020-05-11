package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.DTO.CustomerDTO;

import java.util.Optional;

public interface CustomerService {

    void save0rCreateCustomer(CustomerDTO customerDTO);

    Optional<CustomerDTO> getCustomerByEmail(String email);

}
