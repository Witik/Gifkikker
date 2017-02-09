package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.User;

public interface UserService {

    User getUserByUsername(String name);
}
