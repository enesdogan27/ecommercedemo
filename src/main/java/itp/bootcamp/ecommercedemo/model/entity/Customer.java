package itp.bootcamp.ecommercedemo.model.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String surname;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String address;


}
