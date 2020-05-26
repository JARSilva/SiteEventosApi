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

import com.qintess.spring.entities.Event;
import com.qintess.spring.services.EventService;

@RestController
@CrossOrigin("http://localhost:4200")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/event")
	public List<Event> findAll(){
		return this.eventService.findAll();
	}
	
	@GetMapping("/event/{id}")
	public Event findById(@PathVariable("id") Long id) {
		return this.eventService.findById(id);
	}

	@PostMapping("/event")
	public Event save(@RequestBody Event event) {
		event.setInitialQtdTicket(event.getQtdTicket());
		return this.eventService.saveOrUpdate(event);
	}

	@PutMapping("/event")
	public Event update(@RequestBody Event event) {
		return this.eventService.saveOrUpdate(event);
	}

	@DeleteMapping("/event/{id}")
	public void deleteById(@PathVariable("id") Long id){
		this.eventService.deleteById(id);
	}
}