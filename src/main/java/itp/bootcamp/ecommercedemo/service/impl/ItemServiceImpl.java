package itp.bootcamp.ecommercedemo.service.impl;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;
import itp.bootcamp.ecommercedemo.model.entity.Item;
import itp.bootcamp.ecommercedemo.repository.ItemRepository;
import itp.bootcamp.ecommercedemo.service.ItemService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;

  @Override
  public void createItem(ItemDTO itemDTO) {
    Item item = new Item();
    item.setItemName(itemDTO.getItemName());
    item.setDescription(itemDTO.getDescription());
    item.setCategory(itemDTO.getCategory());
    item.setPrice(itemDTO.getPrice());
    itemRepository.save(item);
  }

  @Override
  public List<ItemDTO> getItemByCategory(Category category) {
    List<ItemDTO> itemList = new ArrayList<>();
    itemRepository.findItemByCategory(category).forEach(item -> {
      ItemDTO itemDTO = new ItemDTO();
      itemDTO.setItemName(item.getItemName());
      itemDTO.setDescription(item.getDescription());
      itemDTO.setCategory(item.getCategory());
      itemDTO.setPrice(item.getPrice());
      itemList.add(itemDTO);
    });

    return itemList;
  }


}
