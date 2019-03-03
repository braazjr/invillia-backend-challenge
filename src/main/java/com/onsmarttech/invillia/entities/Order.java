package com.onsmarttech.invillia.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "store_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Length(min = 10, max = 30)
	private String address;

	@NotNull
	private LocalDate confirmationDate;
	private Boolean status;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order")
	private List<OrderItem> orderItems;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(LocalDate confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public final List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public final void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}