package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.User;
import eu.gillissen.topicus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class UserRepositoryService implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String name) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).filter(user -> user.getName().equals(name)).findAny().orElseThrow(() -> new UsernameNotFoundException(name));
    }
}
