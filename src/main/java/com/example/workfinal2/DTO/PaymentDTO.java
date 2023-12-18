package com.example.workfinal2.DTO;

import java.util.Date;

public class PaymentDTO {
  private Long studentId;
  private String studentName;
  private int paymentAmount;
  private Date paymentDate;

  // getters and setters

  public int getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(int paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

}
