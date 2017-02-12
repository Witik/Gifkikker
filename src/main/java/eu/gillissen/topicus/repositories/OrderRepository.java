package eu.gillissen.topicus.repositories;

import eu.gillissen.topicus.model.WebOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD repository bindings for the WebOrder object.
 */
public interface OrderRepository extends CrudRepository<WebOrder, Integer> {
}
