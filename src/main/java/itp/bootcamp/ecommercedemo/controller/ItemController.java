package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;
import itp.bootcamp.ecommercedemo.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("item")
public class ItemController {
  private final ItemService itemService;

  @PostMapping
  public ResponseEntity createItem(@RequestBody ItemDTO itemDTO) {
    itemService.createItem(itemDTO);
    return ResponseEntity.ok(itemDTO);
  }

  @GetMapping("category/{category}")
  public ResponseEntity getItemByCategory(@PathVariable Category category) {
    List<ItemDTO> itemDTOList = itemService.getItemByCategory(category);
    return ResponseEntity.ok(itemDTOList);
  }
}
