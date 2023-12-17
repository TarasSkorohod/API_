package com.example.workfinal2.controller.TeacherController;

import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.service.TeacherService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
  private final TeacherService teacherService;

  @Autowired
  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @PostMapping
  public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
    Teacher createdTeacher = teacherService.createTeacher(teacher);
    return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
  }

  // Додайте інші ендпойнти для роботи з викладачами
}