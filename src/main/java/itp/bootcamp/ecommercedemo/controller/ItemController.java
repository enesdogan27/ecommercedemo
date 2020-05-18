package itp.bootcamp.ecommercedemo.controller;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("item")
public class ItemController {
    private final ItemService itemService;

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
