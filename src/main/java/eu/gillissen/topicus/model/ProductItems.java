package eu.gillissen.topicus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ProductItems {

    @Id
    @GeneratedValue
    private int id;

    private int amount;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "itemId")
    private StockItem item;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StockItem getItem() {
        return item;
    }

    public void setItem(StockItem item) {
        this.item = item;
    }

}
