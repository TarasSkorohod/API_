package com.example.workfinal2.repository;

import com.example.workfinal2.model.payments.Payment;
import com.example.workfinal2.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
  List<Payment> findByStudent(Student student);
}
