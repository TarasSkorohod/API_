package com.example.workfinal2.repository;

import com.example.workfinal2.model.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  // Додайте методи для роботи із викладачами, які можуть бути потрібні
}