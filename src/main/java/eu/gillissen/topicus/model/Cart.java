package eu.gillissen.topicus.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * The shopping cart.
 */
public class Cart {
    private Map<Product, Integer> cartContents;

    public Map<Product, Integer> getCartContents() {
        return cartContents;
    }

    public Set<Product> getProducts() {
        return cartContents.keySet();
    }

    public Cart() {
        cartContents = new HashMap<>();
    }

    /**
     * Adds a new product, or increments an existing product's counter.
     *
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        Optional<Product> productOptional = cartContents.keySet().stream().filter(inCart -> inCart.equals(product)).findAny();
        if (productOptional.isPresent()) {
            cartContents.replace(productOptional.get(), cartContents.get(productOptional.get()) + 1);
        } else {
            cartContents.put(product, 1);
        }
    }

    /**
     * Calculates and returns the total costs of the cart-contents.
     *
     * @return
     */
    public Euro getTotalCosts() {
        return cartContents.entrySet().stream()
                .map(productIntegerEntry ->
                        productIntegerEntry.getKey().getPrice().times(productIntegerEntry.getValue()))
                .reduce(Euro::plus).orElse(new Euro(0, 0));
    }

    /**
     * Removes a product from the cart.
     *
     * @param product
     */
    public void removeProduct(Product product) {
        Optional<Product> productOptional = cartContents.keySet().stream().filter(inCart -> inCart.equals(product)).findAny();
        productOptional.ifPresent(inCart -> cartContents.remove(inCart));
    }

    public void setCartContents(Map<Product, Integer> cartContents) {
        this.cartContents = cartContents;
    }
}
