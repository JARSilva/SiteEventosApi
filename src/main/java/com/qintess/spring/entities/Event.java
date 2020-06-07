package com.qintess.spring.entities;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "tb_event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Long id;

	@Column(name = "event_name")
	private String name;

	@Column(name = "event_description")
	private String description;

	@Column(name = "event_date")
	private String date;
	
	//url da imagem no projeto angular
	@Column(name = "image_url")
    private String imageUrl;

	@Column(name = "event_price")
	private Double price;

	@Column(name = "event_qtdTicket")
	private Integer qtdTicket;
	
	@Column(name = "event_initialQtdTicket")
	private Integer initialQtdTicket;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "house_id")
	private ShowHouse showHouse;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<Order>();

	public Event() {
	}

	public Event(String name, String description, String date, String imageUrl, Double price, Integer qtdTicket,
			Integer initialQtdTicket, Client client, ShowHouse showHouse) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.imageUrl = imageUrl;
		this.price = price;
		this.qtdTicket = qtdTicket;
		this.initialQtdTicket = initialQtdTicket;
		this.client = client;
		this.showHouse = showHouse;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ShowHouse getShowHouse() {
		return showHouse;
	}

	public void setShowHouse(ShowHouse showHouse) {
		this.showHouse = showHouse;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQtdTicket() {
		return qtdTicket;
	}

	public void setQtdTicket(Integer qtdTicket) {
		this.qtdTicket = qtdTicket;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@JsonIgnore
	public Set<Order> getOrders() {
		return orders;
	}

	

	public Integer getInitialQtdTicket() {
		return initialQtdTicket;
	}



	public void setInitialQtdTicket(Integer initialQtdTicket) {
		this.initialQtdTicket = initialQtdTicket;
	}



	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + ", imageUrl="
				+ imageUrl + ", price=" + price + ", qtdTicket=" + qtdTicket + ", initialQtdTicket=" + initialQtdTicket
				+ ", client=" + client + ", showHouse=" + showHouse + "]";
	}

}
