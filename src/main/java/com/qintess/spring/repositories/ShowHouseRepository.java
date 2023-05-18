package com.qintess.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.ShowHouse;


public interface ShowHouseRepository extends JpaRepository<ShowHouse, Long>{
	
}
