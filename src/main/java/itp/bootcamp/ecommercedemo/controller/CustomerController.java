package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.DTO.CustomerDTO;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity createNewCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
//           Email check without exception handle

//        if (customerService.getCustomerByEmail(customerDTO.getEmail()).isPresent()) {
//            return new ResponseEntity("This email address is in use. If you forgot your password please call help " +
//                    "center.", HttpStatus.BAD_REQUEST);
//        }
        customerService.save0rCreateCustomer(customerDTO);
        return new ResponseEntity("Customer has successfully registered", HttpStatus.OK);
    }

}
