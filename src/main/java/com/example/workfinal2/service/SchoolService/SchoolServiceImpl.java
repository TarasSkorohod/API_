package com.example.workfinal2.service.SchoolService;

import com.example.workfinal2.DTO.PaymentDTO;
import com.example.workfinal2.DTO.TeacherIncomeDTO;
import com.example.workfinal2.model.payments.Payment;
import com.example.workfinal2.model.student.Student;
import com.example.workfinal2.repository.PaymentRepository;
import com.example.workfinal2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
  private final PaymentRepository paymentRepository;
  private final TeacherRepository teacherRepository;

  @Autowired
  public SchoolServiceImpl(PaymentRepository paymentRepository, TeacherRepository teacherRepository) {
    this.paymentRepository = paymentRepository;
    this.teacherRepository = teacherRepository;
  }

  @Override
  public void recordPayment(Long studentId, int amount) {
    // Логіка для запису оплати
    // paymentRepository.save(payment);
  }

  @Override
  public List<PaymentDTO> getTeacherPayments(Long teacherId) {
    return Collections.emptyList();
  }

  @Override
  public List<TeacherIncomeDTO> calculateTeacherIncome() {
    return Collections.emptyList();
  }
}
