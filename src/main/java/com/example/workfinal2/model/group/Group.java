package com.example.workfinal2.model.group;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  // Getters and setters для інших полів, якщо вони є
}
