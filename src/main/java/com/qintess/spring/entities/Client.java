package com.qintess.spring.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "client_name")
	private String name;
	
	@Column(name = "client_cpf")
	private String cpf;
	
	@Column(name = "client_date")
	private String birthDate;
	
	@Column(name = "client_email")
	private String email;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Event> events = new HashSet<Event>();
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<Order>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =  @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public Client() {
		super();
	}


	public Client(String username, String password, String name, String cpf, String birthDate, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.email = email;
	}
	
	public Client(Long id, String username, String password, String name, String cpf, String birthDate, String email,
			Collection<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.email = email;
		this.roles = roles;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	@JsonIgnore
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	@JsonIgnore
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", birthDate=" + birthDate + ", email=" + email
				+ "]";
	}
	
	

}
