package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.entity.Address;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity createNewCustomer(@RequestBody @Valid CustomerDTO customerDTO) {

        customerService.createNewCustomer(customerDTO);
        return new ResponseEntity("Customer has been successfully registered", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity editCustomer(@RequestBody @Valid CustomerDTO customerDTO,
                                       @RequestParam("email") @Email String email) {

        if (customerDTO.getPassword() != null) {
            return new ResponseEntity("You cannot change password", HttpStatus.NOT_ACCEPTABLE);
        }
        customerService.editCustomer(customerDTO, email);
        return new ResponseEntity("Customer has been successfully edited", HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity deleteCustomer(@RequestParam("email") @Email String email) {

        customerService.deleteCustomer(email);
        return new ResponseEntity("Customer has been deleted", HttpStatus.ACCEPTED);

    }


    @PostMapping("address")
    public ResponseEntity createOrUpdateCustomerAddress(@RequestBody Address address,@RequestParam("email") @Email String email) {

        customerService.saveOrUpdateCustomerAddressByEmail(email,address);
        return new ResponseEntity("Customer's address has been successfully updated", HttpStatus.ACCEPTED);
    }


}
