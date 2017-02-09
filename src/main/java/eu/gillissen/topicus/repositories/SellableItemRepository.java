package eu.gillissen.topicus.repositories;

import eu.gillissen.topicus.model.StockItem;
import org.springframework.data.repository.CrudRepository;

public interface SellableItemRepository extends CrudRepository<StockItem, Integer> {
}
