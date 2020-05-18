package itp.bootcamp.ecommercedemo.data;

import itp.bootcamp.ecommercedemo.model.DTO.CustomerDTO;
import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.service.CustomerService;
import itp.bootcamp.ecommercedemo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

import static itp.bootcamp.ecommercedemo.model.constant.Category.*;


@RequiredArgsConstructor
@Component
public class DatabaseInitializer {
    private final CustomerService customerService;
    private final ItemService itemService;

    @PostConstruct
    void load() {
        CustomerDTO customerOne = new CustomerDTO();
        customerOne.setSurname("SMITH");
        customerOne.setName("JOHN");
        customerOne.setAddress("LONDON NW12 3SD");
        customerOne.setEmail("johnsmith@gmail.com");
        customerOne.setPassword("johnsimthlondon");
        customerService.createNewCustomer(customerOne);


        CustomerDTO customerTwo = new CustomerDTO();
        customerTwo.setSurname("WATSON");
        customerTwo.setName("MARRY");
        customerTwo.setAddress("LONDON NW10 22SAS");
        customerTwo.setEmail("marryjane@gmail.com");
        customerTwo.setPassword("marryjanewatson");
        customerService.createNewCustomer(customerTwo);


        CustomerDTO customerThree = new CustomerDTO();
        customerThree.setSurname("LAW");
        customerThree.setName("CHRIS");
        customerThree.setAddress("MANCHESTER M1 12DE");
        customerThree.setEmail("chirslaw@gmail.com");
        customerThree.setPassword("asdasdasd123");
        customerService.createNewCustomer(customerThree);


        CustomerDTO customerFour = new CustomerDTO();
        customerFour.setSurname("LYNN");
        customerFour.setName("JENNIFER");
        customerFour.setAddress("SHEFFIELD S1 3SD");
        customerFour.setEmail("jenny@gmail.com");
        customerFour.setPassword("12341234asd");
        customerService.createNewCustomer(customerFour);


        CustomerDTO customerFive = new CustomerDTO();
        customerFive.setSurname("SMITH");
        customerFive.setName("SUE");
        customerFive.setAddress("LONDON NW12 3SD");
        customerFive.setEmail("suesmith@gmail.com");
        customerFive.setPassword("suesuesue123");
        customerService.createNewCustomer(customerFive);

        ItemDTO itemOne = new ItemDTO();
        itemOne.setBrand("Adidas");
        itemOne.setItemName("NOVA FLOW SHOES");
        itemOne.setDescription("CORE BLACK / CLOUD WHITE / LIGHT GRANITE");
        itemOne.setCategory(MEN);
        itemOne.setPrice(BigDecimal.valueOf(36.50));
        itemOne.setStock(250);
        itemService.createItem(itemOne);


        ItemDTO itemTwo = new ItemDTO();
        itemTwo.setBrand("Adidas");
        itemTwo.setItemName("NOVA FLOW SHOES");
        itemTwo.setDescription("CORE BLACK / CLOUD WHITE / LIGHT GRANITE");
        itemTwo.setCategory(WOMEN);
        itemTwo.setPrice(BigDecimal.valueOf(33.50));
        itemTwo.setStock(330);
        itemService.createItem(itemTwo);


        ItemDTO itemThree = new ItemDTO();
        itemThree.setBrand("HUAWEI");
        itemThree.setItemName("MediaPad T3 10 9.6\" Tablet");
        itemThree.setDescription("The Huawei MediaPad T3 10 9.6\" Tablet features a vibrant HD 800p display, so you " +
                "can comfortably browse, watch videos, or play games.");
        itemThree.setCategory(ELECTRONIC);
        itemThree.setPrice(BigDecimal.valueOf(100.));
        itemThree.setStock(100);
        itemService.createItem(itemThree);


        ItemDTO itemFour = new ItemDTO();
        itemFour.setBrand("UMI");
        itemFour.setItemName("Essentials Tab Top Blackout Curtains");
        itemFour.setDescription("Thermal Insulated Decorative Curtains 55 x 96 Inch Red 2 Panels");
        itemFour.setCategory(HOME);
        itemFour.setPrice(BigDecimal.valueOf(31.50));
        itemFour.setStock(120);
        itemService.createItem(itemFour);


        ItemDTO itemFive = new ItemDTO();
        itemFive.setBrand("Limmys");
        itemFive.setItemName("Magnetic Building Blocks");
        itemFive.setDescription("Unique Travel Series Construction Toys for Boys and Girls – STEM Educational Toy is " +
                "a Perfect Gift – Includes 74 Pieces and an Idea Book");
        itemFive.setCategory(KIDS);
        itemFive.setPrice(BigDecimal.valueOf(25.97));
        itemFive.setStock(70);
        itemService.createItem(itemFive);


    }
}
