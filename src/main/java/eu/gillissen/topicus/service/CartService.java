package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Cart;

/**
 * Shopping-cart service.
 */
public interface CartService {
    /**
     * Returns the shopping cart for the current session.
     *
     * @return a shopping cart object.
     */
    Cart getCart();

    /**
     * Adds a product to the shopping cart.
     *
     * @param productId The id of the product to add.
     */
    void addProduct(Integer productId);

    /**
     * Removes a product from the shopping cart.
     *
     * @param id The id of the product to remove from the shopping cart.
     */
    void removeProduct(Integer id);
}
