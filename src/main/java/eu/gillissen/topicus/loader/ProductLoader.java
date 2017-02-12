package eu.gillissen.topicus.loader;

import eu.gillissen.topicus.model.BeerItem;
import eu.gillissen.topicus.model.Product;
import eu.gillissen.topicus.model.ProductItems;
import eu.gillissen.topicus.model.StockItem;
import eu.gillissen.topicus.repositories.ProductRepository;
import eu.gillissen.topicus.repositories.StockItemRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

/**
 * Populates the database with products and items.
 */
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = Logger.getLogger(ProductLoader.class);

    private ProductRepository productRepository;
    private StockItemRepository itemRepository;

    @Autowired
    public ProductLoader(ProductRepository productRepository, StockItemRepository itemRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        StockItem kistje = new StockItem();
        kistje.setName("Kistje");
        kistje.setDescription("Een mooie verpakking!");
        kistje.setPrice(4, 50);
        kistje.setStock(231);
        kistje = itemRepository.save(kistje);
        logger.info("Saved " + kistje.getName() + " - " + kistje.getId());

        StockItem glas = new StockItem();
        glas.setName("Glas");
        glas.setDescription("Een speciaal gifkikker glas!");
        glas.setPrice(2, 43);
        glas.setStock(138);
        glas = itemRepository.save(glas);
        logger.info("Saved " + glas.getName() + " - " + glas.getId());

        StockItem viltje = new StockItem();
        viltje.setName("Viltje");
        viltje.setDescription("Een viltje met gifkikker logo!");
        viltje.setPrice(0, 25);
        viltje.setStock(5231);
        viltje = itemRepository.save(viltje);
        logger.info("Saved " + viltje.getName() + " - " + viltje.getId());

        StockItem kratje = new StockItem();
        kratje.setName("Kratje");
        kratje.setDescription("Een kratje met plek voor wel 24 flesjes!");
        kratje.setPrice(3, 13);
        kratje.setStock(231);
        kratje = itemRepository.save(kratje);
        logger.info("Saved " + kratje.getName() + " - " + kratje.getId());

        BeerItem fust = new BeerItem();
        fust.setName("Fust Gifkikker");
        fust.setDescription("een fust gevuld met Gifkikker");
        fust.setPrice(35, 00);
        fust.setStock(16);
        fust.setVolume(5000);
        fust.setAlcoholPercentage(7);
        fust.setBeerType("Gifkikker");
        fust = itemRepository.save(fust);
        logger.info("Saved " + fust.getName() + " - " + fust.getId());

        BeerItem bottle = new BeerItem();
        bottle.setName("Flesje Gifkikker");
        bottle.setDescription("een flesje gevuld met Gifkikker");
        bottle.setPrice(4, 20);
        bottle.setStock(253);
        bottle.setVolume(30);
        bottle.setAlcoholPercentage(7);
        bottle.setBeerType("Gifkikker");
        bottle = itemRepository.save(bottle);
        logger.info("Saved " + bottle.getName() + " - " + bottle.getId());

        BeerItem champagne = new BeerItem();
        champagne.setName("Flesje Gifkikker");
        champagne.setDescription("een champagnefles gevuld met Gifkikker");
        champagne.setPrice(6, 20);
        champagne.setStock(225);
        champagne.setVolume(65);
        champagne.setAlcoholPercentage(7);
        champagne.setBeerType("Gifkikker");
        champagne = itemRepository.save(champagne);
        logger.info("Saved " + champagne.getName() + " - " + champagne.getId());


        Product fustProduct = new Product();
        fustProduct.setName("Fust Gifkikker");
        fustProduct.setDescription("Een fust vol gifkikker!");
        fustProduct.setPrice(67, 99);
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
        krat.setPrice(14, 99);
        ProductItems kratFlesjes = new ProductItems();
        kratFlesjes.setAmount(24);
        kratFlesjes.setItem(bottle);
        kratFlesjes.setProduct(krat);
        ProductItems kratKratje = new ProductItems();
        kratKratje.setAmount(1);
        kratKratje.setItem(kratje);
        kratKratje.setProduct(krat);
        krat.setItems(Arrays.asList(kratFlesjes, kratKratje));
        krat = productRepository.save(krat);
        logger.info("Saved " + krat.getName() + " - " + krat.getId());

        Product sixpack = new Product();
        sixpack.setName("Sixpack Gifkikker");
        sixpack.setDescription("6 gifkikkertjes!");
        sixpack.setPrice(3, 99);
        ProductItems sixpackItems = new ProductItems();
        sixpackItems.setAmount(6);
        sixpackItems.setItem(bottle);
        sixpackItems.setProduct(sixpack);
        sixpack.setItems(Collections.singletonList(sixpackItems));
        sixpack = productRepository.save(sixpack);
        logger.info("Saved " + sixpack.getName() + " - " + sixpack.getId());

        Product present = new Product();
        present.setName("Gifkikker Cadeauverpakking");
        present.setDescription("Een kistje vol Gifkikker merchandise!");
        present.setPrice(3, 99);
        ProductItems presentBottles = new ProductItems();
        presentBottles.setAmount(4);
        presentBottles.setItem(bottle);
        presentBottles.setProduct(present);
        ProductItems presentBox = new ProductItems();
        presentBox.setAmount(1);
        presentBox.setItem(kistje);
        presentBox.setProduct(present);
        ProductItems presentGlass = new ProductItems();
        presentGlass.setAmount(1);
        presentGlass.setItem(glas);
        presentGlass.setProduct(present);
        ProductItems presentViltje = new ProductItems();
        presentViltje.setAmount(4);
        presentViltje.setItem(viltje);
        presentViltje.setProduct(present);
        present.setItems(Arrays.asList(presentBox, presentBottles, presentGlass, presentViltje));
        present = productRepository.save(present);
        logger.info("Saved " + present.getName() + " - " + present.getId());

        Product glass = new Product();
        glass.setName("Gifkikker Glas");
        glass.setDescription("Een bierglas met het Gifkikker logo!");
        glass.setPrice(4, 50);
        ProductItems glassGlass = new ProductItems();
        glassGlass.setAmount(1);
        glassGlass.setItem(glas);
        glassGlass.setProduct(glass);
        glass.setItems(Collections.singletonList(glassGlass));
        glass = productRepository.save(glass);
        logger.info("Saved " + glass.getName() + " - " + glass.getId());

        Product flask = new Product();
        flask.setName("Champagnefles");
        flask.setDescription("Een Champagnefles gevuld met Gifkikker!");
        flask.setPrice(7, 50);
        ProductItems flaskChamagne = new ProductItems();
        flaskChamagne.setAmount(1);
        flaskChamagne.setItem(champagne);
        flaskChamagne.setProduct(flask);
        flask.setItems(Collections.singletonList(flaskChamagne));
        flask = productRepository.save(flask);
        logger.info("Saved " + flask.getName() + " - " + flask.getId());
    }
}
