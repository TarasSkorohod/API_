package com.example.workfinal2.model.teacher;

import com.example.workfinal2.model.group.Group;
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
  private List<Group> groups;

  // Constructors, other fields, getters, setters
}
