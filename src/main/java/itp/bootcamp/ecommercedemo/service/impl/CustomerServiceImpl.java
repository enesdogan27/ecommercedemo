package itp.bootcamp.ecommercedemo.service.impl;

import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.entity.Customer;
import itp.bootcamp.ecommercedemo.repository.CustomerRepository;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import itp.bootcamp.ecommercedemo.validation.CustomerEmailNotFoundException;
import itp.bootcamp.ecommercedemo.validation.EmailAlreadyUseException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Customer createNewCustomer(CustomerDTO customerDTO) {
        if (customerRepository.findCustomerByEmail(customerDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUseException();
        }

        Customer customer = new Customer();
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerDTO> getCustomerByEmail(String email) {
        Optional<Customer> customer = customerRepository.findCustomerByEmail(email);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setAddress(customer.get().getAddress());
            customerDTO.setEmail(customer.get().getEmail());
            customerDTO.setName(customer.get().getName());
            customerDTO.setSurname(customer.get().getSurname());
            return Optional.of(customerDTO);
        }
        return Optional.empty();
    }

    @Override
    public void editCustomer(CustomerDTO customerDTO, String email) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(email);
        if (!optionalCustomer.isPresent()) {
            throw new CustomerEmailNotFoundException();
        }
        if (customerRepository.findCustomerByEmail(customerDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUseException();
        }
        Customer customer = optionalCustomer.get();

        if (customerDTO.getSurname() != null) customer.setSurname(customerDTO.getSurname());
        if (customerDTO.getName() != null) customer.setName(customerDTO.getName());
        if (customerDTO.getEmail() != null) customer.setEmail(customerDTO.getEmail());
        if (customerDTO.getAddress() != null) customer.setAddress(customerDTO.getAddress());

        customerRepository.save(customer);


    }
}
