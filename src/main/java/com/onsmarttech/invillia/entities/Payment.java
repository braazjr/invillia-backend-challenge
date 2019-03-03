package com.onsmarttech.invillia.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.onsmarttech.invillia.entities.enums.PaymentStatus;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	@NotBlank
	@Length(min = 16, max = 16)
	private String creditCardNumber;

	@NotNull
	private LocalDate paymentDate;

	@NotNull
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final PaymentStatus getStatus() {
		return status;
	}

	public final void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public final String getCreditCardNumber() {
		return creditCardNumber;
	}

	public final void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public final LocalDate getPaymentDate() {
		return paymentDate;
	}

	public final void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public final Order getOrder() {
		return order;
	}

	public final void setOrder(Order order) {
		this.order = order;
	}

}
