package com.qintess.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long>{
	
	List<Event> findByClient(Client client);
}
