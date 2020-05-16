package itp.bootcamp.ecommercedemo.service.impl;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.model.DTO.StockItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;
import itp.bootcamp.ecommercedemo.model.entity.Item;
import itp.bootcamp.ecommercedemo.model.entity.StockItem;
import itp.bootcamp.ecommercedemo.repository.ItemRepository;
import itp.bootcamp.ecommercedemo.repository.StockItemRepository;
import itp.bootcamp.ecommercedemo.service.ItemService;
import itp.bootcamp.ecommercedemo.service.StockItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StockItemServiceImpl implements StockItemService {

  private final StockItemRepository stockItemRepository;
  private final ModelMapper modelMapper;

  @Override
  public void createStockItem(StockItemDTO stockItemDTO) {

    StockItem stockItem = modelMapper.map(stockItemDTO, StockItem.class );

//    StockItem stockItem = new StockItem();
//    stockItem.setItemName(stockItemDTO.getItemName());

    stockItemRepository.save(stockItem);


  }

  @Override
  public void deleteStockItemById(Integer stockId) {
    stockItemRepository.deleteById(stockId);
  }
}
