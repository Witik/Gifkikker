package eu.gillissen.topicus.repositories;

import eu.gillissen.topicus.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD repository bindings for the User object.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
