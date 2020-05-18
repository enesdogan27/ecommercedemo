package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.entity.Customer;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer2")
public class Customer2Controller {

  @GetMapping
  public List<Customer> getCustomers(){
    return List.of( new Customer());
  }
}
