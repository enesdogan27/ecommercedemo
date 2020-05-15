package itp.bootcamp.ecommercedemo.model.entity;

import itp.bootcamp.ecommercedemo.model.constant.Category;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  @Id
  @GeneratedValue
  private int id;
  private String brand;
  private String itemName;
  private String description;
  private BigDecimal price;
  @Enumerated(value = EnumType.STRING)
  private Category category;
  private int stock;
}
