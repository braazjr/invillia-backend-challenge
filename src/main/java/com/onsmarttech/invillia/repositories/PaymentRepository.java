package com.onsmarttech.invillia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onsmarttech.invillia.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
