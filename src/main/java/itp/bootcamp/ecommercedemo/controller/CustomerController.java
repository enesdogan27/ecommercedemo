package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.dto.CustomerDTO;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//            return new ResponseEntity("This email address is in use. If you forgot your password please call help center.", HttpStatus.BAD_REQUEST);
//        }
        customerService.createNewCustomer(customerDTO);
        return new ResponseEntity("Customer has successfully registered", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity editCustomer(@RequestBody @Valid CustomerDTO customerDTO,
                                       @RequestParam("email") String email)  {
        if(customerDTO.getPassword()!=null){
            return new ResponseEntity("You cannot change password",HttpStatus.BAD_REQUEST);
        }
        customerService.editCustomer(customerDTO,email);
        return new ResponseEntity("Customer has successfully edited", HttpStatus.OK);
    }
    @DeleteMapping("{email}")
    public void deleteCustomer(@PathVariable("email")String email) {
        customerService.deleteCustomer(email);
    }


}
