package itp.bootcamp.ecommercedemo.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String country;
    private String city;
    private String street;
    private String postcode;
    private Integer houseNumber;


}
