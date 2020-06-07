package com.qintess.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.qintess.spring.entities.Client;
import com.qintess.spring.entities.Contact;
import com.qintess.spring.entities.Event;
import com.qintess.spring.entities.Order;
import com.qintess.spring.entities.Role;
import com.qintess.spring.entities.ShowHouse;
import com.qintess.spring.repositories.ClientRepository;
import com.qintess.spring.repositories.ContactRepository;
import com.qintess.spring.repositories.EventRepository;
import com.qintess.spring.repositories.OrderRepository;
import com.qintess.spring.repositories.RoleRepository;
import com.qintess.spring.repositories.ShowHouseRepository;


//Classe que faz os testes no banco h2(banco de teste, utiliza a memoria)
@Configuration
public class TestConfig implements CommandLineRunner {

	//Injeções de dependencia
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ShowHouseRepository showHouseRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		// Testes
		
		Role role = new Role("ROLE_CLIENT");
		
		Role role1 = new Role("ROLE_EVENTMAKER");
		
		roleRepository.saveAll(Arrays.asList(role, role1));
		
		
		
		Client c1 = new Client("Joao", "123", "João", "13213", null, "joaoafon@hotmail.com");
		
		Contact co1 = new Contact("5646564", c1);
		Contact co2 = new Contact("1111111", c1);
		Contact co3 = new Contact("4234243", c1);
		Contact co4 = new Contact("9999999", c1);
		
		ShowHouse sh1 = new ShowHouse("Casa", 20, "1212122", "Rui Barbosa", "123", "PG", "SP");
		ShowHouse sh2 = new ShowHouse("Segunda Casa", 300, "333333", "Campo Sales", "333", "Santos", "SP");
		
		showHouseRepository.saveAll(Arrays.asList(sh1, sh2));

		c1.getContacts().addAll(Arrays.asList(co1, co2, co3, co4));
		clientRepository.save(c1);
		
		
		Event ev1 = new Event("Minha Festa", "Festa pra comemorar algo", "22/04/2001",  null, 20.0, 300,300, c1, sh1);
	
		
		eventRepository.saveAll(Arrays.asList(ev1));
		
		Order or1 = new Order("28-03-4999", 20.0, 1, c1, ev1);	
		
		orderRepository.save(or1);
	}
}
