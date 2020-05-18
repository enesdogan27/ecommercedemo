package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;
import itp.bootcamp.ecommercedemo.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @DeleteMapping("{itemid}")
  public ResponseEntity deleteByItem(@PathVariable(value = "itemid") Integer itemId){
    itemService.deleteByItemId(itemId);
    return ResponseEntity.ok("Item has deleted!");
  }
}
