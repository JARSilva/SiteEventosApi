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

import com.qintess.spring.entities.Client;
import com.qintess.spring.services.ClientService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public List<Client> findAll(){
		return this.clientService.findAll();
	}
	
	@GetMapping("/client/{id}")
	public Client findById(@PathVariable("id") Long id) {
		return this.clientService.findById(id);
	}

	@PostMapping("/client")
	public Client save(@RequestBody Client client) {
		
		return this.clientService.saveOrUpdate(client);
	}

	@PutMapping("/client")
	public Client update(@RequestBody Client client) {
		return this.clientService.saveOrUpdate(client);
	}

	@DeleteMapping("/client/{id}")
	public void deleteById(@PathVariable("id") Long id){
		this.clientService.deleteById(id);
	}
}