package com.onsmarttech.invillia.dao;

import java.time.LocalDate;

public class OrderFilter {

	private String status;
	private LocalDate confirmationDateInitial;
	private LocalDate confirmationDateFinal;
	private Integer storeId;

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	public final LocalDate getConfirmationDateInitial() {
		return confirmationDateInitial;
	}

	public final void setConfirmationDateInitial(LocalDate confirmationDateInitial) {
		this.confirmationDateInitial = confirmationDateInitial;
	}

	public final LocalDate getConfirmationDateFinal() {
		return confirmationDateFinal;
	}

	public final void setConfirmationDateFinal(LocalDate confirmationDateFinal) {
		this.confirmationDateFinal = confirmationDateFinal;
	}

	public final Integer getStoreId() {
		return storeId;
	}

	public final void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

}
