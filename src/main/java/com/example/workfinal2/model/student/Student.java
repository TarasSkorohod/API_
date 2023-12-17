package com.example.workfinal2.model.student;

import com.example.workfinal2.model.group.Group;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "students")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;

  private String name;

  @Column(name = "parent_name")
  private String parentName;

  @Enumerated(EnumType.STRING)
  @Column(name = "payment_type")
  private PaymentType paymentType;

  @Column(name = "price_per_session")
  private int pricePerSession;

  @Column(name = "total_sessions")
  private int totalSessions;

  @Column(name = "remaining_sessions")
  private int remainingSessions;

  @Column(name = "last_payment_date")
  private Date lastPaymentDate;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  public enum PaymentType {
    INDIVIDUAL,
    GROUP
  }

  // Геттери і сеттери для імені та дати останнього платежу
  public String getName() {
    return name;
  }
  public void setGroup(Group group) {
    this.group = group;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getLastPaymentDate() {
    return lastPaymentDate;
  }

  public void setLastPaymentDate(Date lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }
}