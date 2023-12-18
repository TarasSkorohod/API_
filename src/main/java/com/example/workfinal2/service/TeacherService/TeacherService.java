package com.example.workfinal2.service.TeacherService;

import com.example.workfinal2.DTO.TeacherIncomeDTO;
import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeacherService {
  private final TeacherRepository teacherRepository;

  @Autowired
  public TeacherService(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  public Teacher createTeacher(Teacher teacher) {
    return teacherRepository.save(teacher);
  }

  public List<TeacherIncomeDTO> calculateTeacherIncome(Long teacherId) {
    // Логіка для розрахунку доходів від викладача
    return Collections.emptyList();
  }
}