package eu.gillissen.topicus.controller;

import eu.gillissen.topicus.form.OrderMethods;
import eu.gillissen.topicus.model.Address;
import eu.gillissen.topicus.model.User;
import eu.gillissen.topicus.service.OrderService;
import eu.gillissen.topicus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class OrderController {

    private UserService userService;
    private OrderService orderService;

    @Autowired
    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @RequestMapping("/order")
    public String order(Principal principal, Model model) {
        if (principal == null) {
            return "orderRegisterLogin";
        } else {
            return orderAddress(principal, model);
        }
    }


    @RequestMapping("/order/address")
    public String orderAddress(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());
        orderService.deleteOrder(user.getId());
        model.addAttribute("user", user);
        return "orderAddress";
    }

    @RequestMapping(value = "/order/address/{userId}", method = RequestMethod.POST)
    public String orderAddressConfirm(Principal principal, Model model, @PathVariable Integer userId, Address address) {
        User user = userService.getUserByUsername(principal.getName());
        if (user.getId() == userId) {
            orderService.setAddress(userId, address);
            model.addAttribute("user", user);
            return "orderMethod";
        } else {
            model.addAttribute("user", user);
            return "orderAddress";
        }
    }

    @RequestMapping(value = "/order/method/{userId}", method = RequestMethod.POST)
    public String orderMethodConfirm(Principal principal, Model model, @PathVariable Integer userId, OrderMethods orderMethods) {
        User user = userService.getUserByUsername(principal.getName());
        if (user.getId() == userId) {
            orderService.setPaymentMethod(userId, orderMethods.getPaymentMethod());
            orderService.setShippingMethod(userId, orderMethods.getShippingMethod());
            model.addAttribute("order",orderService.getOrder(userId));
            model.addAttribute("user", user);
            return "orderConfirm";
        } else {
            model.addAttribute("user", user);
            return "orderMethod";
        }
    }

    @RequestMapping("/order/submit/{userId}")
    public String orderAddress(Principal principal, Model model, @PathVariable Integer userId) {
        User user = userService.getUserByUsername(principal.getName());
        if (user.getId() == userId) {
            orderService.submitOrder(userId);
            return "orderSubmitted";
        } else {
            model.addAttribute("order",orderService.getOrder(userId));
            model.addAttribute("user", user);
            return "orderConfirm";
        }
    }
}
