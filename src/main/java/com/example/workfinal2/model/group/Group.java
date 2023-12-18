package com.example.workfinal2.model.group;

import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.model.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long groupId;

  @JsonProperty("groupName")
  @Column(name = "group_name")
  private String groupName;

  @JsonProperty("teacherId")
  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;

  @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Student> students;

  public Group() {

  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return "Group{" +
            "groupId=" + groupId +
            ", groupName='" + groupName + '\'' +
            ", teacher=" + teacher +
            ", students=" + students +
            '}';
  }
}
