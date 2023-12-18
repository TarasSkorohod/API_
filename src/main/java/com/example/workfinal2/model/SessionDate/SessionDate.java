package com.example.workfinal2.model.SessionDate;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.List;

public class SessionDate {
  @Temporal(TemporalType.DATE)
  private Date date;

  public SessionDate(Date date) {
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
