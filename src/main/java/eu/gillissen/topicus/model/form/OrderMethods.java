package eu.gillissen.topicus.model.form;

/**
 * Data object to map the result of the method step to.
 */
public class OrderMethods {
    private String paymentMethod;

    private String shippingMethod;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
