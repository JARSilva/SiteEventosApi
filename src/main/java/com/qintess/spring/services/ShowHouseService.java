package com.qintess.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Event;
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.repositories.ClientRepository;
import com.qintess.spring.repositories.ShowHouseRepository;

@Service
public class ShowHouseService {

	@Autowired
	private ShowHouseRepository showHouseRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ShowHouse saveOrUpdate(ShowHouse showHouse) {
		return this.showHouseRepository.save(showHouse);
	}
	
	public ShowHouse findById(Long id) {
		return this.showHouseRepository.findById(id).get();
	}
	
	public List<ShowHouse> findAll(){
		return this.showHouseRepository.findAll();
	}
	
	public List<ShowHouse> findAllByClient(Long id){
		Client client = this.clientRepository.findById(id).get();
		return this.showHouseRepository.findByClient(client);
	}
	
	public void deleteById(Long id) {
		this.showHouseRepository.deleteById(id);
	}
	
}