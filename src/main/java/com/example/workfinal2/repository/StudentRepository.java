package com.example.workfinal2.repository;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  Student findByName(String name);
  List<Student> findByGroupIn(List<Group> groups);

}
