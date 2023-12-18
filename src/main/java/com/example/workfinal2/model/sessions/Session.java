package com.example.workfinal2.model.sessions;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "sessions")
@Getter
@Setter
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "session_date")
  private Date sessionDate;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  public Session(Long id, Date sessionDate, Group group, Teacher teacher) {
    this.id = id;
    this.sessionDate = sessionDate;
    this.group = group;
    this.teacher = teacher;
  }

  public Session() {

  }

  public Long getId() {
    return id;
  }

  public Date getSessionDate() {
    return sessionDate;
  }

  public Group getGroup() {
    return group;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSessionDate(Date sessionDate) {
    this.sessionDate = sessionDate;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }


  // Constructors, other fields, getters, setters
}