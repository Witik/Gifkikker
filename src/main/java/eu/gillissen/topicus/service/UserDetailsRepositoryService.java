package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.User;
import eu.gillissen.topicus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.StreamSupport;

@Component
public class UserDetailsRepositoryService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsRepositoryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User matchUser = StreamSupport.stream(userRepository.findAll().spliterator(), false).filter(user -> user.getName().equalsIgnoreCase(s)).findAny().orElseThrow(() -> new UsernameNotFoundException(s));
        return userToUserDetails(matchUser);
    }

    private UserDetails userToUserDetails(User user) {
        String username = user.getName();
        String password = user.getPassword();
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getRole());
        return new org.springframework.security.core.userdetails.User(username, password, authorities);
    }
}
