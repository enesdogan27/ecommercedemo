package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;
import itp.bootcamp.ecommercedemo.model.DTO.StockItemDTO;
import itp.bootcamp.ecommercedemo.model.constant.Category;

import java.util.List;

public interface StockItemService {

  void createStockItem(StockItemDTO stockItemDTO);

  void deleteStockItemById(Integer stockId);


}
