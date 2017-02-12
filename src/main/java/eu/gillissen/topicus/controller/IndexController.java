package eu.gillissen.topicus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Mapping of the index page.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
