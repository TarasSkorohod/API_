package com.example.workfinal2.controller.PaymentController;

import com.example.workfinal2.DTO.PaymentDTO;
import com.example.workfinal2.model.payments.Payment;
import com.example.workfinal2.service.PaymentService.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
  private final PaymentService paymentService;

  @Autowired
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/create")
  public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
    try {
      Payment createdPayment = paymentService.createPayment(payment);
      return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/student-payments/{studentId}")
  public ResponseEntity<List<PaymentDTO>> getStudentPayments(@PathVariable Long studentId) {
    List<PaymentDTO> studentPayments = paymentService.getStudentPayments(studentId);
    return ResponseEntity.ok(studentPayments);
  }
}