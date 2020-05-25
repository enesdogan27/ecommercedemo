package itp.bootcamp.ecommercedemo.service.impl;

import itp.bootcamp.ecommercedemo.model.dto.StockItemDTO;
import itp.bootcamp.ecommercedemo.model.entity.StockItem;
import itp.bootcamp.ecommercedemo.repository.StockItemRepository;
import itp.bootcamp.ecommercedemo.service.StockItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StockItemServiceImpl implements StockItemService {

  private final StockItemRepository stockItemRepository;
  private final ModelMapper modelMapper;

  @Override
  public void createStockItem(StockItemDTO stockItemDTO) {
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = LocalDateTime.now();
    StockItem stockItem = modelMapper.map(stockItemDTO, StockItem.class );
    stockItem.setItemCreatedDate(localDate);
    stockItem.setItemUpdated(localDateTime);
    stockItemRepository.save(stockItem);
  }

  @Override
  public void deleteStockItemById(Integer stockId) {
    stockItemRepository.deleteById(stockId);
  }

//  @Override
//  public List<StockItemDTO> getAllStockItem() {
//    List<StockItemDTO> stockItemDTOS = new ArrayList<>();
//    stockItemRepository.findAll().forEach(stockItem -> {
//      StockItemDTO stockItemDTO = new StockItemDTO();
//      stockItemDTO.setBrand(stockItem.getBrand());
//      stockItemDTO.setCategory(stockItem.getCategory());
//      stockItemDTO.setDescription(stockItem.getDescription());
//      stockItemDTO.setItemName(stockItem.getItemName());
//      stockItemDTO.setPrice(stockItem.getPrice());
//      stockItemDTO.setStock(stockItem.getStock());
//      stockItemDTOS.add(stockItemDTO);
//    });
//    return stockItemDTOS;
//  }

  @Override
  public List<StockItemDTO> getAllStockItem() {
    List<StockItem> stockItems = (List<StockItem>) stockItemRepository.findAll();
       List<StockItemDTO> stockItemDTOS = stockItems.stream()
               .map(source -> modelMapper.map(source, StockItemDTO.class))
               .collect(Collectors.toList());
    return stockItemDTOS;
  }

}
