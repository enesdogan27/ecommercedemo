package itp.bootcamp.ecommercedemo.service.impl;

import itp.bootcamp.ecommercedemo.model.dto.ItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;
import itp.bootcamp.ecommercedemo.model.entity.Item;
import itp.bootcamp.ecommercedemo.repository.ItemRepository;
import itp.bootcamp.ecommercedemo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import java.math.BigDecimal;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
  private final ItemRepository itemRepository;
  private final ModelMapper modelMapper;

  @Override
  public void createItem(ItemDTO itemDTO) {
    Item item = modelMapper.map(itemDTO, Item.class);
    itemRepository.save(item);
  }

  @Override
  public List<ItemDTO> getItemByCategory(Category category) {
    //  enum disi bir deger girilirse bunun exceptionini nerede nasil yazmaliyiz?????
    List<ItemDTO> itemList = new ArrayList<>();
    itemRepository.findItemByCategory(category).forEach(item -> {
      ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
      itemList.add(itemDTO);
    });
    return itemList;
  }

    @Override
    public List<ItemDTO> searchItem(String search, String sort) {


        return itemRepository.findItemByDescriptionContainingIgnoreCase(search, Sort.by(sort)).stream().map(item -> modelMapper.map(item,
                ItemDTO.class)).collect(Collectors.toList());


    }

  @Override
  public void deleteByItemId(int itemId) {
    Optional<Item> deleteItem = itemRepository.findById(itemId);
    if (!deleteItem.isPresent()){
      throw new RuntimeException("Item can not be found!");

    }
    itemRepository.deleteById(itemId);
  }
  
      @Override
    public Optional<ItemDTO> findById(Integer id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (!optionalItem.isPresent())
            return Optional.empty();

        return Optional.of(modelMapper.map(optionalItem.get(), ItemDTO.class));
    }

    @Override
    public Optional<ItemDTO> updateItem(Integer itemId, ItemDTO itemDTO) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (!optionalItem.isPresent()) {
            return Optional.empty();
        }

        Item item = optionalItem.get();

        if (itemDTO.getBrand() != null && itemDTO.getBrand().length() > 0)
            item.setBrand(itemDTO.getBrand());
        if (itemDTO.getCategory() != null)
            item.setCategory(itemDTO.getCategory());
        if (itemDTO.getDescription() != null && itemDTO.getDescription().length() > 0)
            item.setDescription(itemDTO.getDescription());
        if (itemDTO.getItemName() != null && itemDTO.getItemName().length() > 0)
            item.setItemName(itemDTO.getItemName());
        if (itemDTO.getPrice() != null && itemDTO.getPrice().compareTo(BigDecimal.ZERO) > 0)
            item.setPrice(itemDTO.getPrice());
        int stock = itemDTO.getStock();
        if (stock > 0) {
            stock += item.getStock();
            item.setStock(stock);
        }

        itemRepository.save(item);

        return Optional.of(modelMapper.map(item, ItemDTO.class));
    }
}
