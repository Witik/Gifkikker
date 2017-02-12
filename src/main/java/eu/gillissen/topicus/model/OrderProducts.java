package eu.gillissen.topicus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Order and products join-table object.
 */
@Entity
public class OrderProducts {

    @Id
    @GeneratedValue
    private int id;

    private int amount;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "orderId")
    private WebOrder webOrder;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "productId")
    private Product product;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public WebOrder getWebOrder() {
        return webOrder;
    }

    public void setWebOrder(WebOrder webOrder) {
        this.webOrder = webOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

