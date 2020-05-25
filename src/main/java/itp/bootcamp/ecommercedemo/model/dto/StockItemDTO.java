package itp.bootcamp.ecommercedemo.model.dto;

import itp.bootcamp.ecommercedemo.model.constant.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockItemDTO {

  private String brand;
  private String itemName;
  private String description;
  private BigDecimal price;
  private Category category;
  private int stock;
}
