package eu.gillissen.topicus.model;

import java.io.Serializable;

public class ProductItemId implements Serializable {

    private int productId;
    private int itemId;

    public int hashCode() {
        return (productId + itemId);
    }

    public boolean equals(Object object) {
        if (object instanceof ProductItemId) {
            ProductItemId otherId = (ProductItemId) object;
            return (otherId.productId == this.productId) && (otherId.itemId == this.itemId);
        }
        return false;
    }
}
