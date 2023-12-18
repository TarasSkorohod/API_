package com.example.workfinal2.repository;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
  Group findByGroupName(String groupName);
  List<Group> findByTeacher(Teacher teacher);


}
