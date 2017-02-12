package eu.gillissen.topicus.repositories;

import eu.gillissen.topicus.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD repository bindings for the Product object.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
