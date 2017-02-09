package eu.gillissen.topicus.service;

import eu.gillissen.topicus.model.Address;
import eu.gillissen.topicus.model.Cart;
import eu.gillissen.topicus.model.WebOrder;
import eu.gillissen.topicus.model.OrderProducts;
import eu.gillissen.topicus.model.OrderStatus;
import eu.gillissen.topicus.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Collectors;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class OrderSessionService implements OrderService {

    private CartService cartService;
    private OrderRepository orderRepository;
    private WebOrder webOrder;

    @Autowired
    public OrderSessionService(CartService cartService, OrderRepository orderRepository) {
        this.cartService = cartService;
        this.orderRepository = orderRepository;
    }

    @Override
    public WebOrder getOrder(Integer userId) {
        if (webOrder == null || webOrder.getUserId() != userId) {
            Cart cart = cartService.getCart();
            webOrder = new WebOrder();
            putCartProductsInOrder(cart, webOrder);
            webOrder.setUserId(userId);
            return webOrder;
        }
        return webOrder;
    }

    private void putCartProductsInOrder(Cart cart, WebOrder webOrder) {
        webOrder.setProducts(
                cart.getCartContents().entrySet().stream().map(cartProducts -> {
                    OrderProducts products = new OrderProducts();
                    products.setAmount(cartProducts.getValue());
                    products.setProduct(cartProducts.getKey());
                    products.setWebOrder(webOrder);
                    return products;
                }).collect(Collectors.toList())
        );
    }

    @Override
    public void setAddress(Integer userId, Address address) {
        getOrder(userId).setAddress(address);
    }

    @Override
    public void setPaymentMethod(Integer userId, String paymentMethod) {
        getOrder(userId).setPaymentMethod(paymentMethod);
    }

    @Override
    public void setShippingMethod(Integer userId, String shippingMethod) {
        getOrder(userId).setShippingMethod(shippingMethod);
    }

    @Override
    public void submitOrder(Integer userId) {
        webOrder.setStatus(OrderStatus.BEING_PROCESSED.toString());
        orderRepository.save(webOrder);
        webOrder = null;
    }

    @Override
    public void deleteOrder(Integer userId) {
        webOrder = null;
    }
}
