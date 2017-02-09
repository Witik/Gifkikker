package eu.gillissen.topicus.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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

    public void addProduct(Product product) {
        Optional<Product> productOptional = cartContents.keySet().stream().filter(inCart -> inCart.equals(product)).findAny();
        if (productOptional.isPresent()) {
            cartContents.replace(productOptional.get(), cartContents.get(productOptional.get()) + 1);
        } else {
            cartContents.put(product, 1);
        }
    }

    public void setProductCount(Product product, int count) {
        cartContents.put(product, count);
    }

    public Euro getTotalCosts() {
        return cartContents.entrySet().stream()
                .map(productIntegerEntry ->
                        productIntegerEntry.getKey().getPrice().times(productIntegerEntry.getValue()))
                .reduce(Euro::plus).orElse(new Euro());
    }

    public void removeProduct(Product product) {
        Optional<Product> productOptional = cartContents.keySet().stream().filter(inCart -> inCart.equals(product)).findAny();
        productOptional.ifPresent(inCart -> cartContents.remove(inCart));
    }

    public void setCartContents(Map<Product, Integer> cartContents) {
        this.cartContents = cartContents;
    }
}
