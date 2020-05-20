package itp.bootcamp.ecommercedemo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.entity.Customer;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import itp.bootcamp.ecommercedemo.validation.EmailAlreadyUseException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
public class CustomerControllerTest {

  @Mock
  CustomerService customerService;

  @InjectMocks
  CustomerController customerController;


  @Test
  public void testCustomerCreate(){

    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setEmail("customer@gmail.com");
    customerDTO.setName("Customer One");
    customerDTO.setPassword("passw0rd");

    Customer customer = new Customer();
    customer.setEmail("customer@gmail.com");
    customer.setName("Customer One");
    customer.setPassword("passw0rd");
    customer.setId(1);

    when(customerService.createNewCustomer(customerDTO)).thenReturn(customer);

    ResponseEntity<Customer> responseEntity = customerController.createNewCustomer(customerDTO);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody().getId()).isNotNull();
    System.out.println(responseEntity.getBody().getId());
  }

  @Test
  public void GivenDuplicateEmailWhenCreateCustomerThenReturnException(){

    CustomerDTO customerDTOOne = new CustomerDTO();
    customerDTOOne.setEmail("customer@gmail.com");
    customerDTOOne.setName("Customer One");
    customerDTOOne.setPassword("passw0rd");
    customerController.createNewCustomer(customerDTOOne);

    CustomerDTO customerDTOTwo = new CustomerDTO();
    customerDTOTwo.setEmail("customer@gmail.com");
    customerDTOTwo.setName("Customer Two");
    customerDTOTwo.setPassword("passw0rd");

    assertThatThrownBy(() -> customerController.createNewCustomer(customerDTOTwo))
        .hasMessageContaining("This ertyu address is in use");

    assertThatThrownBy(() -> customerController.createNewCustomer(customerDTOTwo))
        .isInstanceOf(EmailAlreadyUseException.class);
  }
}
