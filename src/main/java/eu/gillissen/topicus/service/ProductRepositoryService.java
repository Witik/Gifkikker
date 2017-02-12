package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Product;
import eu.gillissen.topicus.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service for the Product repository.
 */
@Component
public class ProductRepositoryService implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductRepositoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findOne(id);
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }
}
