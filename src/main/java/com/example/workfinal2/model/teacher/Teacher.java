package com.example.workfinal2.model.teacher;

import com.example.workfinal2.model.group.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(name = "payment_rate")
  private int paymentRate;

  @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Group> groups;
  public Teacher(Long id, String name, int paymentRate, List<Group> groups) {
    this.id = id;
    this.name = name;
    this.paymentRate = paymentRate;
    this.groups = groups;
  }
  public Teacher() {
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPaymentRate() {
    return paymentRate;
  }

  public void setPaymentRate(int paymentRate) {
    this.paymentRate = paymentRate;
  }

  public List<Group> getGroups() {
    return groups;
  }

  public void setGroups(List<Group> groups) {
    this.groups = groups;
  }

  @Override
  public String toString() {
    return "Teacher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", paymentRate=" + paymentRate +
            ", groups=" + groups +
            '}';
  }

}
