package com.example.workfinal2.controller.StudentController;

import com.example.workfinal2.model.student.Student;
import com.example.workfinal2.service.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/students")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/create-student")
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    Student createdStudent = studentService.createStudent(student);
    return ResponseEntity.ok(createdStudent);
  }

  @PostMapping("/add-to-group/{groupId}")
  public ResponseEntity<Student> addStudentToGroup(
          @PathVariable Long groupId,
          @RequestBody Map<String, Long> requestBody
  ) {
    try {
      Long studentId = requestBody.get("studentId");
      Student student = studentService.addStudentToGroup(studentId, groupId);
      return new ResponseEntity<>(student, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}


