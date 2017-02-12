package eu.gillissen.topicus.repositories;

import eu.gillissen.topicus.model.StockItem;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD repository bindings for the StockItem object.
 */
public interface StockItemRepository extends CrudRepository<StockItem, Integer> {
}
