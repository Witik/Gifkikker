package eu.gillissen.topicus.controller;

import eu.gillissen.topicus.model.User;
import eu.gillissen.topicus.model.form.UserRegistration;
import eu.gillissen.topicus.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User manage and login controller.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Login mapping.
     *
     * @return the Thymleaf login template name
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Register page mapping
     *
     * @return the Thymleaf register template name
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * Register result mapping
     *
     * @param userRegistration The user registration information object.
     * @return The model and view result.
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, UserRegistration userRegistration) {
        if (userService.getUserByUsername(userRegistration.getName()) == null) {
            model.addAttribute("error", "name");
            logger.info("name error");
            return "register";
        }
        if (!userRegistration.getPassword().equals(userRegistration.getPasswordCheck())) {
            model.addAttribute("error", "pass");
            logger.info("pass error");
            return "register";
        }
        User user = new User();
        user.setName(userRegistration.getName());
        user.setPassword(userRegistration.getPassword());
        user.setRole("USER");
        userService.save(user);
        logger.info(user.getName() + " registered");
        return "redirect:/login";
    }
}
