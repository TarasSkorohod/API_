package com.example.workfinal2.service.StudentService;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.student.Student;
import com.example.workfinal2.repository.GroupRepository;
import com.example.workfinal2.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class StudentService {

  private final StudentRepository studentRepository;
  private final GroupRepository groupRepository;

  @Autowired
  public StudentService(final StudentRepository studentRepository, final GroupRepository groupRepository) {
    this.studentRepository = studentRepository;
    this.groupRepository = groupRepository;
  }


  @Transactional
  public Student createStudent(Student student) {
    validateStudentCreation(student);

    // Set the last payment date to the current date
    student.setLastPaymentDate(new Date());

    // Set the session dates
    List<Date> sessionDates = student.getSessionDates();
    if (sessionDates != null && !sessionDates.isEmpty()) {
      student.setSessionDates(sessionDates);
    }

    return studentRepository.save(student);
  }


  @Transactional
  public Student addStudentToGroup(Long studentId, Long groupId) {
    Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new EntityNotFoundException("Студент з id " + studentId + " не знайдений"));

    Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new EntityNotFoundException("Група з id " + groupId + " не знайдена"));

    student.setGroup(group);
    studentRepository.save(student);

    return student;
  }

  private void validateStudentCreation(Student student) {
    // Логіка валідації
    System.out.println("Студент для створення: " + student);
  }
}
