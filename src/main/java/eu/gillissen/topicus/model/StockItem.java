package eu.gillissen.topicus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

/**
 * Single items for which stock is kept track of.
 */
@Entity
@Inheritance
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Euro price;
    private int stock;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Euro getPrice() {
        return price;
    }

    public void setPrice(Euro price) {
        this.price = price;
    }

    public void setPrice(int euro, int cents) {
        this.price = new Euro(euro, cents);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
