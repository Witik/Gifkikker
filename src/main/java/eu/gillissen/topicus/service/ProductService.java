package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Product;

public interface ProductService {
    void saveProduct(Product product);

    Product getProductById(int id);

    Iterable<Product> listAllProducts();

    void deleteProduct(int id);
}
