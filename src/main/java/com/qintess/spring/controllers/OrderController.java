package com.qintess.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.spring.entities.Order;
import com.qintess.spring.services.OrderService;

@RestController
@CrossOrigin("http://localhost:4200")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public List<Order> findAll(){
		return this.orderService.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Order findById(@PathVariable("id") Long id) {
		return this.orderService.findById(id);
	}

	@PostMapping("/order")
	public Order save(@RequestBody Order order) throws Exception {
			
			return this.orderService.saveOrUpdate(order);
	}

	@PutMapping("/order")
	public Order update(@RequestBody Order order) throws Exception {
		return this.orderService.saveOrUpdate(order);
	}

	@DeleteMapping("/order/{id}")
	public void deleteById(@PathVariable("id") Long id){
		this.orderService.deleteById(id);
	}
}
