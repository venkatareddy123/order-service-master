package com.sivalabs.orderservice.web.controllers;

import com.sivalabs.orderservice.entities.Order;
import com.sivalabs.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private OrderRepository repo;

    @Autowired
    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/api/orders")
    @PreAuthorize("hasAuthority('role_admin')")
    public Order createOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    @GetMapping("/api/orders/{id}")
    @PreAuthorize("hasAnyAuthority('role_admin','role_user')")
	public Order findOrderById(@PathVariable Long id) {
		Order order = null;
		Optional<Order> optionalOrder = repo.findById(id);
		if (optionalOrder.isPresent()) {
			order = optionalOrder.get();
		}
		return order;
	}
	@GetMapping("/api/orders/all")
    @PreAuthorize("hasAnyAuthority('role_admin')")
	public List<Order> findAllOrders() {
		List<Order> orders = repo.findAll();
		return orders;
	}
    @GetMapping("/api/orders/greeting")
	public String greeting() {
		return "Hellow Adimurthy";
	}

}
