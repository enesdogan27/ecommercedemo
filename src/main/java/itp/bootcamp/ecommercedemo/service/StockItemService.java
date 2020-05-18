package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.dto.StockItemDTO;

import java.util.List;

public interface StockItemService {

  void createStockItem(StockItemDTO stockItemDTO);

  void deleteStockItemById(Integer stockId);

  List<StockItemDTO> getAllStockItem();

}
