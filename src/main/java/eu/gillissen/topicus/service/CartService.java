package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Cart;

public interface CartService {
    Cart getCart();

    void addProduct(Integer productId);

    void removeProduct(Integer id);
}
