package com.example.workfinal2.service.SchoolService;

import com.example.workfinal2.DTO.PaymentDTO;
import com.example.workfinal2.DTO.TeacherIncomeDTO;

import java.util.List;

// SchoolService.java
public interface SchoolService {
  void recordPayment(Long studentId, int amount);
  List<PaymentDTO> getTeacherPayments(Long teacherId);
  List<TeacherIncomeDTO> calculateTeacherIncome();
}