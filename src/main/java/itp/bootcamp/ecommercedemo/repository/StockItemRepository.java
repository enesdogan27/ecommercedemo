package itp.bootcamp.ecommercedemo.repository;

import itp.bootcamp.ecommercedemo.model.entity.StockItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemRepository extends CrudRepository<StockItem, Integer> {
}
