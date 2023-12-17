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
  private Long sessionId;

  @Column(name = "session_date")
  private Date sessionDate;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  // Getters and setters
}