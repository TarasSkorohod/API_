package com.example.workfinal2.model.TeacherStatistics;

import com.example.workfinal2.model.teacher.Teacher;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "teacher_statistics")
public class TeacherStatistics {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @Temporal(TemporalType.DATE)
  @Column(name = "session_date")
  private Date sessionDate;

  @Column(name = "group_sessions")
  private int groupSessions;

  @Column(name = "individual_sessions")
  private int individualSessions;

  @Column(name = "salary_earned")
  private int salaryEarned;

  @Column(name = "total_session_cost")
  private int totalSessionCost;

  @Column(name = "school_earnings")
  private int schoolEarnings;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Date getSessionDate() {
    return sessionDate;
  }

  public void setSessionDate(Date sessionDate) {
    this.sessionDate = sessionDate;
  }

  public int getGroupSessions() {
    return groupSessions;
  }

  public void setGroupSessions(int groupSessions) {
    this.groupSessions = groupSessions;
  }

  public int getIndividualSessions() {
    return individualSessions;
  }

  public void setIndividualSessions(int individualSessions) {
    this.individualSessions = individualSessions;
  }

  public int getSalaryEarned() {
    return salaryEarned;
  }

  public void setSalaryEarned(int salaryEarned) {
    this.salaryEarned = salaryEarned;
  }

  public int getTotalSessionCost() {
    return totalSessionCost;
  }

  public void setTotalSessionCost(int totalSessionCost) {
    this.totalSessionCost = totalSessionCost;
  }

  public int getSchoolEarnings() {
    return schoolEarnings;
  }

  public void setSchoolEarnings(int schoolEarnings) {
    this.schoolEarnings = schoolEarnings;
  }
}