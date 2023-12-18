package com.example.workfinal2.service.StudentService;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.student.Student;
import com.example.workfinal2.repository.GroupRepository;
import com.example.workfinal2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class StudentService {

  private final StudentRepository studentRepository;
  private final GroupRepository groupRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
    this.studentRepository = studentRepository;
    this.groupRepository = groupRepository;
  }

  @Transactional
  public Student createStudent(Student student) {
    validateStudentCreation(student);
    student.setLastPaymentDate(new Date());
    return studentRepository.save(student);
  }

  @Transactional
  public Student addStudentToGroup(Long studentId, Long groupId) {
    Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Студент з id " + studentId + " не знайдений"));

    Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new RuntimeException("Група з id " + groupId + " не знайдена"));

    student.setGroup(group);
    studentRepository.save(student);

    return student;
  }

  private void validateStudentCreation(Student student) {
    // Логіка валідації
    System.out.println("Студент для створення: " + student);
  }
}
