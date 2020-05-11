package itp.bootcamp.ecommercedemo.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CustomerDTO {

    private String name;

    private String surname;

    @Email
    private String email;

    @Size(min = 8, max = 15)
    private String password;

    private String address;

}
