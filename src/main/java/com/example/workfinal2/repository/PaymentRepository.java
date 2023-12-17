package com.example.workfinal2.repository;

import com.example.workfinal2.model.payments.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  // Додайте методи для роботи із платежами, які можуть бути потрібні
}
