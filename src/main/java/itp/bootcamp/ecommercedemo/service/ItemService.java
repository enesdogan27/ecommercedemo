package itp.bootcamp.ecommercedemo.service;

import itp.bootcamp.ecommercedemo.model.DTO.ItemDTO;

import java.util.Optional;

public interface ItemService {
    Optional<ItemDTO> findById(Integer id);

    Optional<ItemDTO> updateItem(Integer itemId, ItemDTO itemDTO);
}
