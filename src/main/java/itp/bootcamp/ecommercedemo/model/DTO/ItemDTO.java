package itp.bootcamp.ecommercedemo.model.DTO;

import itp.bootcamp.ecommercedemo.model.constant.Category;
import java.math.BigDecimal;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  private int stockId;
  @Enumerated(value = EnumType.STRING)
  private Category category;

}
