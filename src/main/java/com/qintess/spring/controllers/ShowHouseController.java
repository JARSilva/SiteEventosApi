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

import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.services.ShowHouseService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ShowHouseController {

	@Autowired
	private ShowHouseService showHouseService;
	
	@GetMapping("/showHouse")
	public List<ShowHouse> findAll(){
		return this.showHouseService.findAll();
	}
	
	@GetMapping("/showHouse/{id}")
	public ShowHouse findById(@PathVariable("id") Long id) {
		return this.showHouseService.findById(id);
	}

	@PostMapping("/showHouse")
	public ShowHouse save(@RequestBody ShowHouse showHouse) {
		return this.showHouseService.saveOrUpdate(showHouse);
	}

	@PutMapping("/showHouse")
	public ShowHouse update(@RequestBody ShowHouse showHouse) {
		return this.showHouseService.saveOrUpdate(showHouse);
	}

	@DeleteMapping("/showHouse/{id}")
	public void deleteById(@PathVariable("id") Long id){
		this.showHouseService.deleteById(id);
	}
}
