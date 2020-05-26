package com.qintess.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Client;
import com.qintess.spring.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client saveOrUpdate(Client client) {
		return this.clientRepository.save(client);
	}
	
	public Client findById(Long id) {
		return this.clientRepository.findById(id).get();
	}
	
	public List<Client> findAll(){
		return this.clientRepository.findAll();
	}
	
	
	public void deleteById(Long id) {
		this.clientRepository.deleteById(id);
	}
	
}

