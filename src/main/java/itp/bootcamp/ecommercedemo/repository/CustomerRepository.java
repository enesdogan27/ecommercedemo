package itp.bootcamp.ecommercedemo.repository;

import itp.bootcamp.ecommercedemo.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findCustomerByEmail(String email);

}
