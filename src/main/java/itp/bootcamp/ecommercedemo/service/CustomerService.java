package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;

import itp.bootcamp.ecommercedemo.model.entity.Customer;
import java.util.Optional;

public interface CustomerService {

    Customer createNewCustomer(CustomerDTO customerDTO);

    Optional<CustomerDTO> getCustomerByEmail(String email);

    void editCustomer(CustomerDTO customerDTO,String email);

}
