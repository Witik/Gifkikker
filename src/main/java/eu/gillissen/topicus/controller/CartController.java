package eu.gillissen.topicus.controller;

import eu.gillissen.topicus.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for the store shopping cart.
 */
@Controller
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Mapping for shopping cart view
     *
     * @param model view model
     * @return Thymeleaf template name
     */
    @RequestMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cartShow";
    }

    /**
     * Mapping to remove a product from the cart.
     *
     * @param model     view model
     * @param productId The id of the removed product.
     * @return Thymeleaf template name
     */
    @RequestMapping("/cart/remove/{productId}")
    public String removeProduct(Model model, @PathVariable Integer productId) {
        cartService.removeProduct(productId);
        model.addAttribute("cart", cartService.getCart());
        return "cartShow";
    }

    /**
     * Mapping to add a product to the cart.
     *
     * @param productId The id of the product to add.
     * @return JSON result
     */
    @RequestMapping(path = "/cart/add/{productId}", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    String addToCart(@PathVariable Integer productId) {
        cartService.addProduct(productId);
        return "{\"status\"=\"okay\"}";
    }
}
