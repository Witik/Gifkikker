package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.User;

/**
 * Service for users.
 */
public interface UserService {

    /**
     * Returns a user by it's username.
     *
     * @param name The name of the user to return.
     * @return a User object or null if it doesn't exist.
     */
    User getUserByUsername(String name);
}
