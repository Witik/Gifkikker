package eu.gillissen.topicus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User manage and login controller.
 */
@Controller
public class UserController {

    /**
     * Login mapping.
     *
     * @return the Thymleaf login template name
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
