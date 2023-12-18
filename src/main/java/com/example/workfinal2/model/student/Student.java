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

  @JsonProperty("phoneNumber")
  @Column(name = "phone_number")
  private String phoneNumber; // Додано нове поле "номер телефону"

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

  @JsonProperty("attendedOnSession")
  @Column(name = "attended_on_session")
  private boolean attendedOnSession;

  @Column(name = "is_present")
  private boolean isPresent;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  public Student() {
  }

  public enum PaymentType {
    INDIVIDUAL,
    GROUP
  }

  public Student(Long studentId, String name, String parentName, String phoneNumber, PaymentType paymentType, int pricePerSession, int totalSessions, int remainingSessions, Date lastPaymentDate, boolean attendedOnSession, boolean isPresent, Group group) {
    this.studentId = studentId;
    this.name = name;
    this.parentName = parentName;
    this.phoneNumber = phoneNumber;
    this.paymentType = paymentType;
    this.pricePerSession = pricePerSession;
    this.totalSessions = totalSessions;
    this.remainingSessions = remainingSessions;
    this.lastPaymentDate = lastPaymentDate;
    this.attendedOnSession = attendedOnSession;
    this.isPresent = isPresent;
    this.group = group;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public int getPricePerSession() {
    return pricePerSession;
  }

  public void setPricePerSession(int pricePerSession) {
    this.pricePerSession = pricePerSession;
  }

  public int getTotalSessions() {
    return totalSessions;
  }

  public void setTotalSessions(int totalSessions) {
    this.totalSessions = totalSessions;
  }

  public int getRemainingSessions() {
    return remainingSessions;
  }

  public void setRemainingSessions(int remainingSessions) {
    this.remainingSessions = remainingSessions;
  }

  public Date getLastPaymentDate() {
    return lastPaymentDate;
  }

  public void setLastPaymentDate(Date lastPaymentDate) {
    this.lastPaymentDate = lastPaymentDate;
  }

  public boolean isAttendedOnSession() {
    return attendedOnSession;
  }

  public void setAttendedOnSession(boolean attendedOnSession) {
    this.attendedOnSession = attendedOnSession;
  }

  public boolean isPresent() {
    return isPresent;
  }

  public void setPresent(boolean present) {
    isPresent = present;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  @Override
  public String toString() {
    return "Student{" +
            "studentId=" + studentId +
            ", name='" + name + '\'' +
            ", parentName='" + parentName + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", paymentType=" + paymentType +
            ", pricePerSession=" + pricePerSession +
            ", totalSessions=" + totalSessions +
            ", remainingSessions=" + remainingSessions +
            ", lastPaymentDate=" + lastPaymentDate +
            ", attendedOnSession=" + attendedOnSession +
            ", isPresent=" + isPresent +
            ", group=" + group +
            '}';
  }
}
