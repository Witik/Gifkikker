package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Address;
import eu.gillissen.topicus.model.WebOrder;

/**
 * WebOrder service.
 */
public interface OrderService {

    /**
     * Sets the address of the unfinished order.
     *
     * @param userId  The id of the user which' order to set the address.
     * @param address The new address of the order.
     */
    void setAddress(Integer userId, Address address);

    /**
     * Returns the unfinished order of the given user. If none exist, one will be created.
     *
     * @param userId The id of the user which order to return.
     * @return an order object.
     */
    WebOrder getOrder(Integer userId);

    /**
     * Sets the payment method of the unfinished order.
     *
     * @param userId        The id of the user which' order to set the method.
     * @param paymentMethod The new method of the order.
     */
    void setPaymentMethod(Integer userId, String paymentMethod);

    /**
     * Sets the shipping method of the unfinished order.
     *
     * @param userId        The id of the user which' order to set the method.
     * @param paymentMethod The new method of the order.
     */
    void setShippingMethod(Integer userId, String paymentMethod);

    /**
     * Submits an order to the database.
     *
     * @param userId The id user which' order to submit.
     */
    void submitOrder(Integer userId);

    /**
     * Deletes the unfinished order.
     *
     * @param userId The id user which' order to delete.
     */
    void deleteOrder(Integer userId);
}
