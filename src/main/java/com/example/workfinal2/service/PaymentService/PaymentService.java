package com.example.workfinal2.service.PaymentService;

import com.example.workfinal2.DTO.PaymentDTO;
import com.example.workfinal2.model.payments.Payment;
import com.example.workfinal2.repository.PaymentRepository;
import com.example.workfinal2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PaymentService {
  private final PaymentRepository paymentRepository;
  private final StudentRepository studentRepository;

  @Autowired
  public PaymentService(PaymentRepository paymentRepository, StudentRepository studentRepository) {
    this.paymentRepository = paymentRepository;
    this.studentRepository = studentRepository;
  }

  public Payment createPayment(Payment payment) {
    validatePaymentCreation(payment);
    return paymentRepository.save(payment);
  }

  private void validatePaymentCreation(Payment payment) {
    // Логіка валідації оплати перед збереженням
  }

  public List<PaymentDTO> getStudentPayments(Long studentId) {
    // Логіка для отримання оплат для студента
    return Collections.emptyList();
  }
}