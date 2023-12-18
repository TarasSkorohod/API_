package com.example.workfinal2.controller.TeacherController;

import com.example.workfinal2.DTO.TeacherIncomeDTO;
import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.service.TeacherService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
  private final TeacherService teacherService;

  @Autowired
  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @PostMapping("/create")
  public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
    Teacher createdTeacher = teacherService.createTeacher(teacher);
    return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
  }

  @GetMapping("/{teacherId}/income")
  public ResponseEntity<List<TeacherIncomeDTO>> calculateTeacherIncome(@PathVariable Long teacherId) {
    List<TeacherIncomeDTO> teacherIncome = teacherService.calculateTeacherIncome(teacherId);
    return new ResponseEntity<>(teacherIncome, HttpStatus.OK);
  }
  @PostMapping("/{teacherId}/add-to-group/{groupId}")
  public ResponseEntity<Teacher> addToGroup(@PathVariable Long teacherId, @PathVariable Long groupId) {
    Teacher updatedTeacher = teacherService.addTeacherToGroup(teacherId, groupId);
    return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
  }

}
