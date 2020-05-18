package itp.bootcamp.ecommercedemo.repository;

import itp.bootcamp.ecommercedemo.model.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
