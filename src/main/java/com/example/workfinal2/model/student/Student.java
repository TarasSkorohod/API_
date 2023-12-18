package com.example.workfinal2.model.student;

import com.example.workfinal2.model.group.Group;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty("name")
  private String name;

  @JsonProperty("parentName")
  @Column(name = "parent_name")
  private String parentName;

  @JsonProperty("paymentType")
  @Enumerated(EnumType.STRING)
  @Column(name = "payment_type")
  private PaymentType paymentType;

  @JsonProperty("pricePerSession")
  @Column(name = "price_per_session")
  private int pricePerSession;

  @JsonProperty("totalSessions")
  @Column(name = "total_sessions")
  private int totalSessions;

  @JsonProperty("remainingSessions")
  @Column(name = "remaining_sessions")
  private int remainingSessions;

  @JsonProperty("lastPaymentDate")
  @Column(name = "last_payment_date")
  private Date lastPaymentDate;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  public Student() {

  }

  public enum PaymentType {
    INDIVIDUAL,
    GROUP
  }

  @Override
  public String toString() {
    return "Student{" +
            "studentId=" + studentId +
            ", name='" + name + '\'' +
            ", parentName='" + parentName + '\'' +
            ", paymentType=" + paymentType +
            ", pricePerSession=" + pricePerSession +
            ", totalSessions=" + totalSessions +
            ", remainingSessions=" + remainingSessions +
            ", lastPaymentDate=" + lastPaymentDate +
            ", group=" + (group != null ? group.getGroupId() : null) +
            '}';
  }
  public void setLastPaymentDate(Date lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }

  public void setGroup(Group group) {
    this.group = group;
  }
}

