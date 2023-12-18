package com.example.workfinal2.controller.SchoolController;

import com.example.workfinal2.DTO.PaymentDTO;
import com.example.workfinal2.DTO.TeacherIncomeDTO;
import com.example.workfinal2.service.SchoolService.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SchoolController.java
@RestController
@RequestMapping("api/school")
public class SchoolController {

  @Autowired
  private SchoolService schoolService;

  @PostMapping("/record-payment")
  public ResponseEntity<String> recordPayment(@RequestParam Long studentId, @RequestParam int amount) {
    schoolService.recordPayment(studentId, amount);
    return ResponseEntity.ok("Payment recorded successfully");
  }

  @GetMapping("/teacher-payments/{teacherId}")
  public ResponseEntity<List<PaymentDTO>> getTeacherPayments(@PathVariable Long teacherId) {
    List<PaymentDTO> teacherPayments = schoolService.getTeacherPayments(teacherId);
    return ResponseEntity.ok(teacherPayments);
  }

  @GetMapping("/calculate-teacher-income")
  public ResponseEntity<List<TeacherIncomeDTO>> calculateTeacherIncome() {
    List<TeacherIncomeDTO> teacherIncome = schoolService.calculateTeacherIncome();
    return ResponseEntity.ok(teacherIncome);
  }
}
