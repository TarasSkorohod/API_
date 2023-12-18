package com.example.workfinal2.model.group;

import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.model.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long groupId;

  @Column(name = "group_name")
  private String groupName;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
  private List<Student> students;

  // Constructors, other fields, getters, setters
}
