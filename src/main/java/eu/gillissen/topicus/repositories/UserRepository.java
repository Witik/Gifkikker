package eu.gillissen.topicus.repositories;

import eu.gillissen.topicus.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
