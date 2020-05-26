package com.qintess.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.repositories.ShowHouseRepository;

@Service
public class ShowHouseService {

	@Autowired
	private ShowHouseRepository showHouseRepository;
	
	public ShowHouse saveOrUpdate(ShowHouse showHouse) {
		return this.showHouseRepository.save(showHouse);
	}
	
	public ShowHouse findById(Long id) {
		return this.showHouseRepository.findById(id).get();
	}
	
	public List<ShowHouse> findAll(){
		return this.showHouseRepository.findAll();
	}
	
	
	public void deleteById(Long id) {
		this.showHouseRepository.deleteById(id);
	}
	
}