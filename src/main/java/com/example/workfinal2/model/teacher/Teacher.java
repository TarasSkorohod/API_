package com.example.workfinal2.model.teacher;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long teacherId;

  private String name;

  @Column(name = "payment_rate")
  private int paymentRate;

  // Getters and setters
}
