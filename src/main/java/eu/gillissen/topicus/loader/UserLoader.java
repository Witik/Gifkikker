package eu.gillissen.topicus.loader;

import eu.gillissen.topicus.model.Address;
import eu.gillissen.topicus.model.User;
import eu.gillissen.topicus.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = Logger.getLogger(UserLoader.class);

    private UserRepository userRepository;

    @Autowired
    public UserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User admin = new User();
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setRole("ADMIN");
        User saved = userRepository.save(admin);
        logger.info("Saved " + saved.getName() + " - " + saved.getId());

        Address address = new Address();
        address.setCity("Deventer");
        address.setHouseNumber("69");
        address.setNumberAddition("b");
        address.setPostalCode("1337XD");
        address.setStreet("Edwinstraat");
        address.setRecipient("Edwin van de Ridder");

        User edwin = new User();
        edwin.setName("edwin");
        edwin.setPassword("edwin");
        edwin.setRole("USER");
        edwin.setAddress(address);
        saved = userRepository.save(edwin);
        logger.info("Saved " + saved.getName() + " - " + saved.getId());

        User user = new User();
        user.setName("user");
        user.setPassword("user");
        user.setRole("USER");
        saved = userRepository.save(user);
        logger.info("Saved " + saved.getName() + " - " + saved.getId());
    }
}
