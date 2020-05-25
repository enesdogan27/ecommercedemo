package itp.bootcamp.ecommercedemo.service;


import java.util.Optional;
import itp.bootcamp.ecommercedemo.model.dto.ItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;
import java.util.List;

public interface ItemService {

  void createItem(ItemDTO itemDTO);

  Optional<ItemDTO> findById(Integer id);

  Optional<ItemDTO> updateItem(Integer itemId, ItemDTO itemDTO);

  List<ItemDTO> getItemByCategory(Category category);

  void deleteByItemId(int itemId);

  List<ItemDTO> searchItem(String search,String sort);
}
