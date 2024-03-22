package com.devcg.matriz.repositories;

import com.devcg.matriz.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
