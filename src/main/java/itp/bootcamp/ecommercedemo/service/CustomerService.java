package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.DTO.CustomerDTO;

import java.util.Optional;

public interface CustomerService {

    void createNewCustomer(CustomerDTO customerDTO);

    Optional<CustomerDTO> getCustomerByEmail(String email);

    void editCustomer(CustomerDTO customerDTO,String email);

    void deleteCustomer(String email);




}
