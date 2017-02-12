package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Cart;
import eu.gillissen.topicus.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * The Shopping cart service, scoped to the client session.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class CartSessionService implements CartService {

    private Cart cart;
    private ProductService productService;

    @Autowired
    public CartSessionService(ProductService productService) {
        this.cart = new Cart();
        this.productService = productService;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void addProduct(Integer productId) {
        Product product = productService.getProductById(productId);
        cart.addProduct(product);
    }

    @Override
    public void removeProduct(Integer productId) {
        Product product = productService.getProductById(productId);
        cart.removeProduct(product);
    }
}
