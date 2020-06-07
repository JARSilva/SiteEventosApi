package com.qintess.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Event;
import com.qintess.spring.entities.Order;
import com.qintess.spring.repositories.EventRepository;
import com.qintess.spring.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	public Order saveOrUpdate(Order order) throws Exception {
		Event event = eventRepository.findById(order.getEvent().getId()).get();
		if(order.getQtd() > 4 || order.getQtd() <= 0 || order.getQtd() > event.getQtdTicket()) {
			throw new Exception("Número de ingressos invalido");
		}else {	
			event.setQtdTicket(event.getQtdTicket() - order.getQtd());
			eventRepository.save(event); 
			return this.orderRepository.save(order);
		}
	}
	
	public Order findById(Long id) {
		return this.orderRepository.findById(id).get();
	}
	
	public List<Order> findAll(){
		return this.orderRepository.findAll();
	}
	
	
	public void deleteById(Long id) {
		this.orderRepository.deleteById(id);
	}
	
}
