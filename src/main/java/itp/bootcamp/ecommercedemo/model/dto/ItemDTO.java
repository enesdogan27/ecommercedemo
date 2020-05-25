package itp.bootcamp.ecommercedemo.model.dto;

import itp.bootcamp.ecommercedemo.model.constant.Category;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

  private String brand;
  private String itemName;
  private String description;
  private BigDecimal price;
  private Category category;
  private int stock;
}
