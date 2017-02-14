package eu.gillissen.topicus.controller;

import eu.gillissen.topicus.model.Product;
import eu.gillissen.topicus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Product CRUD controller.
 */
@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Create product view.
     *
     * @param model view model.
     * @return the Thymeleaf template name.
     */
    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    /**
     * Create product result mapping.
     *
     * @param product The product to create.
     * @return the Thymeleaf template name.
     */
    @RequestMapping(value = "product/create", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/show/" + product.getId();
    }

    /**
     * The single product view.
     *
     * @param id    The id of the product to show.
     * @param model The view model
     * @return the Thymeleaf template name.
     */
    @RequestMapping(value = "product/show/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productShow";
    }

    /**
     * The complete product list.
     *
     * @param model The view model.
     * @return the Thymeleaf template name.
     */
    @RequestMapping("products")
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    /**
     * Delete product view.
     *
     * @param id The id of the product to delete.
     * @return the Thymeleaf template name.
     */
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
