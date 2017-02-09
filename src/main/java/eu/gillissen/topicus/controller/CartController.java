package eu.gillissen.topicus.controller;

import eu.gillissen.topicus.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cartShow";
    }

    @RequestMapping("/cart/remove/{productId}")
    public String removeProduct(Model model, @PathVariable Integer productId) {
        cartService.removeProduct(productId);
        model.addAttribute("cart", cartService.getCart());
        return "cartShow";
    }

    @RequestMapping(path = "/cart/add/{productId}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody String addToCart(@PathVariable Integer productId) {
        cartService.addProduct(productId);
        return "okay";
    }
}
