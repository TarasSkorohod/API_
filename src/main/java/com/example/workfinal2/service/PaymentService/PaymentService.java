package com.example.workfinal2.service.PaymentService;

import com.example.workfinal2.model.payments.Payment;
import com.example.workfinal2.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
  private final PaymentRepository paymentRepository;

  @Autowired
  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public Payment createPayment(Payment payment) {
    // Логіка для створення оплати
    return paymentRepository.save(payment);
  }

  // Додайте інші методи для роботи з оплатами
}