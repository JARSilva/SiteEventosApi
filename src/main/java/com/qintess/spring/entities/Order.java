package com.qintess.spring.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name = "order_total")
	private Double total;
	
	@Column(name = "order_qtd")
	private Integer qtd; 
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.REFRESH})
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "event_id")
	private Event event;
	
	public Order() {
		super();
	}
	
	public Order(String orderDate, Double total, Integer qtd, Client client, Event event) {
		super();
		this.orderDate = orderDate;
		this.total = total;
		this.qtd = qtd;
		this.client = client;
		this.event = event;
	}
	
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", qtd=" + qtd + ", client="
				+ client + "]";
	}
	
	

}
