package com.onsmarttech.invillia.dao;

import java.time.LocalDate;

import com.onsmarttech.invillia.entities.enums.OrderStatus;

public class OrderFilter {

	private OrderStatus status;
	private LocalDate confirmationDateInitial;
	private LocalDate confirmationDateFinal;
	private Integer storeId;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDate getConfirmationDateInitial() {
		return confirmationDateInitial;
	}

	public void setConfirmationDateInitial(LocalDate confirmationDateInitial) {
		this.confirmationDateInitial = confirmationDateInitial;
	}

	public LocalDate getConfirmationDateFinal() {
		return confirmationDateFinal;
	}

	public void setConfirmationDateFinal(LocalDate confirmationDateFinal) {
		this.confirmationDateFinal = confirmationDateFinal;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

}
