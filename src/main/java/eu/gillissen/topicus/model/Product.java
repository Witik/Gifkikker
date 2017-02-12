package eu.gillissen.topicus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * A product on sale in the webshop.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;
    private Euro price;
    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductItems> items;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ProductItems> getItems() {
        return items;
    }

    public void setItems(List<ProductItems> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product other = (Product) obj;
            return other.getId() == this.getId();
        }
        return false;
    }
}
