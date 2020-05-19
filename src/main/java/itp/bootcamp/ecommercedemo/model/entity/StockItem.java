package itp.bootcamp.ecommercedemo.model.entity;

import itp.bootcamp.ecommercedemo.model.constant.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockItem {

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
  private LocalDate itemCreatedDate;
  private LocalDateTime itemUpdated;
}
