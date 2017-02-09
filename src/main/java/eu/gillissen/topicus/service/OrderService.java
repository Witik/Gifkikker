package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Address;
import eu.gillissen.topicus.model.WebOrder;

public interface OrderService {

    void setAddress(Integer userId, Address address);

    WebOrder getOrder(Integer userId);

    void setPaymentMethod(Integer userId, String paymentMethod);

    void setShippingMethod(Integer userId, String paymentMethod);

    void submitOrder(Integer userId);

    void deleteOrder(Integer userId);
}
