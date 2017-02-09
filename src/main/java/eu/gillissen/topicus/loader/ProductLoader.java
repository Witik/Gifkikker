package eu.gillissen.topicus.loader;

import eu.gillissen.topicus.model.BeerItem;
import eu.gillissen.topicus.model.Product;
import eu.gillissen.topicus.model.ProductItems;
import eu.gillissen.topicus.repositories.ProductRepository;
import eu.gillissen.topicus.repositories.SellableItemRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = Logger.getLogger(ProductLoader.class);

    private ProductRepository productRepository;
    private SellableItemRepository itemRepository;

    @Autowired
    public ProductLoader(ProductRepository productRepository, SellableItemRepository itemRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        BeerItem fust = new BeerItem();
        fust.setName("Fust Gifkikker");
        fust.setDescription("een 50L fust gevuld met Gifkikker");
        fust.setPrice(35.00);
        fust.setStock(16);
        fust.setVolume(5000);
        fust.setAlcoholPercentage(7);
        fust.setBeerType("Gifkikker");
        fust = itemRepository.save(fust);
        logger.info("Saved " + fust.getName() + " - " + fust.getId());

        BeerItem bottle = new BeerItem();
        bottle.setName("Flesje Gifkikker");
        bottle.setDescription("een 0.3L flesje gevuld met Gifkikker");
        bottle.setPrice(4.20);
        bottle.setStock(253);
        bottle.setVolume(30);
        bottle.setAlcoholPercentage(7);
        bottle.setBeerType("Gifkikker");
        bottle = itemRepository.save(bottle);
        logger.info("Saved " + bottle.getName() + " - " + bottle.getId());


        Product fustProduct = new Product();
        fustProduct.setName("Fust Gifkikker");
        fustProduct.setDescription("Een fust vol gifkikker!");
        fustProduct.setPrice(67.99);
        ProductItems fustItems = new ProductItems();
        fustItems.setAmount(1);
        fustItems.setItem(fust);
        fustItems.setProduct(fustProduct);
        fustProduct.setItems(Collections.singletonList(fustItems));
        fustProduct = productRepository.save(fustProduct);
        logger.info("Saved " + fustProduct.getName() + " - " + fustProduct.getId());

        Product krat = new Product();
        krat.setName("Krat Gifkikker");
        krat.setDescription("Een kratje met 24 gifkikkertjes!");
        krat.setPrice(14.99);
        ProductItems kratItems = new ProductItems();
        kratItems.setAmount(24);
        kratItems.setItem(bottle);
        kratItems.setProduct(krat);
        krat.setItems(Collections.singletonList(kratItems));
        krat = productRepository.save(krat);
        logger.info("Saved " + krat.getName() + " - " + krat.getId());
    }
}
