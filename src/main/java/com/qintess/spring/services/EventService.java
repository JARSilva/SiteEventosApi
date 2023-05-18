package com.qintess.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Event;
import com.qintess.spring.repositories.ClientRepository;
import com.qintess.spring.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Event saveOrUpdate(Event event) {
		return this.eventRepository.save(event);
	}
	
	public Event findById(Long id) {
		return this.eventRepository.findById(id).get();
	}
	
	public List<Event> findAll(){
		return this.eventRepository.findAll();
	}
	public List<Event> findAllByClient(Long id){
		Client client = this.clientRepository.findById(id).get();
		return this.eventRepository.findByClient(client);
	}
	
	public void deleteById(Long id) {
		this.eventRepository.deleteById(id);
	}
	
}
