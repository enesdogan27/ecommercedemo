package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.entity.Address;
import itp.bootcamp.ecommercedemo.model.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer createNewCustomer(CustomerDTO customerDTO);

    Customer editCustomer(CustomerDTO customerDTO, String email);

    boolean deleteCustomer(String email);

    Customer saveOrUpdateCustomerAddressByEmail(String email, Address address);




}
