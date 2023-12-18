package com.example.workfinal2.model.payments;

import com.example.workfinal2.model.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Payment.java
@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  private int amount;

  @Column(name = "payment_date")
  private Date paymentDate;

  // Constructors, other fields, getters, setters
}