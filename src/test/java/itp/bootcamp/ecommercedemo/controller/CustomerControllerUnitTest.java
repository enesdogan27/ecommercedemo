package itp.bootcamp.ecommercedemo.controller;


import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.entity.Customer;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvcBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void test() {

        Customer customer = new Customer();
        CustomerDTO customerDTO = new CustomerDTO();

        when(customerService.createNewCustomer(customerDTO)).thenReturn(customer);
        assertEquals(HttpStatus.OK, customerController.createNewCustomer(customerDTO).getStatusCode());
        //assertThrows(Exception.class,() -> customerController.createNewCustomer(customerDTO));
    }

    public Customer getCustomer(){
        return new Customer();
    }


}
