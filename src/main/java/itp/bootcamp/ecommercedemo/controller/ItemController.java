package itp.bootcamp.ecommercedemo.controller;
import itp.bootcamp.ecommercedemo.model.dto.ItemDTO;
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

    @GetMapping("search")
    public ResponseEntity searchItem(@RequestParam(name = "search") String search, @RequestParam("sort") String sort) {
        if (search.length() < 3 || search.length() > 30) {
            return ResponseEntity.badRequest().body("You can search between 3-30 character");
        }
        return ResponseEntity.ok(itemService.searchItem(search, sort));

    }
  
    @PutMapping("/{itemId}")
    public ResponseEntity addItem(@PathVariable Integer itemId, @RequestBody @Valid ItemDTO itemDTO) {
        if (itemDTO.getStock() <= 0) {
            return new ResponseEntity(String.format("Stock count must be greater than zero. stock=%d", itemDTO.getStock()), BAD_REQUEST);
        }
        Optional<ItemDTO> optionalItemDTO = itemService.updateItem(itemId, itemDTO);
        if (!optionalItemDTO.isPresent()) {
            return new ResponseEntity("Item not found", NOT_FOUND);
        }
        return ResponseEntity.ok(optionalItemDTO.get());
    }

    @GetMapping("/{itemId}")
    private ResponseEntity getById(@PathVariable Integer itemId) {
        Optional<ItemDTO> optionalItemDTO = itemService.findById(itemId);
        if (optionalItemDTO.isPresent())
            return ResponseEntity.ok(optionalItemDTO.get());

        return new ResponseEntity("Item not found", NOT_FOUND);
    }
}
