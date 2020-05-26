package itp.bootcamp.ecommercedemo.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.entity.Address;
import itp.bootcamp.ecommercedemo.model.entity.Customer;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CustomerControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    ObjectMapper om = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void createNewCustomerTest() {

        when(customerService.createNewCustomer(getCustomerDTO())).thenReturn(getCustomer());
        assertEquals(HttpStatus.CREATED, customerController.createNewCustomer(getCustomerDTO()).getStatusCode());
    }

    @Test
    void givenWrongEmailFormatWhenCreateNewCustomer() throws Exception {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setEmail("wrongemail");
        String jsonRequest = om.writeValueAsString(customerDTO);
        mockMvc.perform(post("/customer")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }


    @Test
    void givenWrongPasswordFormatWhenCreateNewCustomer() throws Exception {
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setPassword("asd");
        String jsonRequest = om.writeValueAsString(customerDTO);
        mockMvc.perform(post("/customer")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenTrueCustomerWhenCreateNewCustomer() throws Exception {
        CustomerDTO customerDTO = getCustomerDTO();
        String jsonRequest = om.writeValueAsString(customerDTO);
        mockMvc.perform(post("/customer")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(content().string("Customer has been successfully registered"));
    }


    @Test
    void editCustomerTest() {
        String email = "customeremain@mail.com";
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setPassword(null);
        when(customerService.editCustomer(customerDTO, email)).thenReturn(getCustomer());
        assertEquals(HttpStatus.ACCEPTED, customerController.editCustomer(customerDTO, email).getStatusCode());
    }

    @Test
    void givenTrueCustomerWhenEditCustomer() throws Exception {

        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setPassword(null);
        String jsonRequest = om.writeValueAsString(customerDTO);
        String email = "customer@mail.com";

        mockMvc.perform(put("/customer")
                .param("email", email)
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Customer has been successfully edited"));
    }

    @Test
    void givenWrongEmailFormatWhenEditCustomer() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        CustomerDTO customerDTO = getCustomerDTO();
        customerDTO.setPassword(null);
        String wrongEmail = "wrongemail";
        String trueEmail = "customer@mail.com";
        String jsonRequest = om.writeValueAsString(customerDTO);
        mockMvc.perform(put("/customer")
                .param("email", wrongEmail)
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("editCustomer.email: must be a well-formed email address"));
        customerDTO.setEmail(wrongEmail);
        jsonRequest = om.writeValueAsString(customerDTO);
        mockMvc.perform(put("/customer")
                .param("email", trueEmail)
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }


    @Test
    void givenCustomerDTOHasPasswordWhenEditCustomerTest() {
        String email = "customer@mail.com";
        CustomerDTO customerDTO = getCustomerDTO();
        when(customerService.editCustomer(customerDTO, email)).thenReturn(getCustomer());
        assertEquals(HttpStatus.NOT_ACCEPTABLE, customerController.editCustomer(customerDTO, email).getStatusCode());
        assertEquals("You cannot change password", customerController.editCustomer(customerDTO, email).getBody());
    }


    @Test
    void deleteCustomerTest() {
        String email = "customeremain@mail.com";
        when(customerService.deleteCustomer(email)).thenReturn(true);
        assertEquals(HttpStatus.ACCEPTED, customerController.deleteCustomer(email).getStatusCode());

    }

    @Test
    void givenWrongEmailFormatCustomerWhenDeleteCustomer() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String email = "wrongemail";
        mockMvc.perform(delete("/customer")
                .param("email", email))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("deleteCustomer.email: must be a well-formed email address"));
    }

    @Test
    void givenTrueCustomerWhenDeleteCustomer() throws Exception {
        String email = "customer@mail";
        mockMvc.perform(delete("/customer")
                .param("email", email))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Customer has been deleted"));
    }

    @Test
    void createOrUpdateCustomerAddressTest() {
        String email = "customeremain@mail.com";
        when(customerService.saveOrUpdateCustomerAddressByEmail(email, getAddress())).thenReturn(getCustomer());
        assertEquals(HttpStatus.ACCEPTED, customerController.deleteCustomer(email).getStatusCode());

    }

    @Test
    void givenTrueAddressWhenDeleteCustomer() throws Exception {
        String email = "customer@mail";
        String jsonRequest = om.writeValueAsString(getCustomerDTO());
        mockMvc.perform(post("/customer/address")
                .param("email", email)
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Customer's address has been successfully updated"));
    }

    @Test
    void givenWrongEmailFormatWhenDeleteCustomer() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String email = "wrongmail";
        String jsonRequest = om.writeValueAsString(getCustomerDTO());
        mockMvc.perform(post("/customer/address")
                .param("email", email)
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("createOrUpdateCustomerAddress.email: must be a well-formed email address"));
    }

    public static Customer getCustomer() {
        return new Customer();

    }

    public static CustomerDTO getCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("customer@mail.com");
        customerDTO.setPassword("passwordtext");
        customerDTO.setName("test");
        customerDTO.setSurname("customer");

        customerDTO.setAddress(getAddress());
        return customerDTO;
    }

    public static Address getAddress() {
        Address address = new Address();
        address.setCountry("United Kingdom");
        address.setCity("Manchester");
        address.setStreet("Blackburn Road");
        address.setPostcode("BL12DD");
        address.setHouseNumber(133);
        return address;
    }


}
