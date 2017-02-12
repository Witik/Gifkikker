package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Product;

/**
 * Product Service.
 */
public interface ProductService {
    /**
     * Saves a new Product.
     *
     * @param product Product to save.
     */
    void saveProduct(Product product);

    /**
     * Retrieves a product by product id.
     *
     * @param id The id of the product to retrieve.
     * @return The product or null if it doesn't exist.
     */
    Product getProductById(int id);

    /**
     * Retrieves a list of all products.
     *
     * @return All products.
     */
    Iterable<Product> listAllProducts();

    /**
     * Removes a product with the specified id.
     *
     * @param id The id of the product to remove.
     */
    void deleteProduct(int id);
}
