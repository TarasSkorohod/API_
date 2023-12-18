package com.example.workfinal2.service.PaymentService;

import com.example.workfinal2.DTO.PaymentDTO;
import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.payments.Payment;
import com.example.workfinal2.model.student.Student;
import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.repository.GroupRepository;
import com.example.workfinal2.repository.PaymentRepository;
import com.example.workfinal2.repository.StudentRepository;
import com.example.workfinal2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PaymentService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private GroupRepository groupRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  public void processPayments() {
    // Логіка опрацювання оплат для всіх студентів
    List<Student> students = studentRepository.findAll();
    for (Student student : students) {
      processStudentPayment(student);
    }

    // Логіка розрахунку доходу викладачів
    List<Teacher> teachers = teacherRepository.findAll();
    for (Teacher teacher : teachers) {
      calculateTeacherIncome(teacher);
    }
  }

  private void processStudentPayment(Student student) {
    // Логіка списання коштів від студента
    // Отримання інформації про групу та викладача
    Group group = student.getGroup();
    Teacher teacher = group.getTeacher();

    // Логіка розрахунку вартості заняття для студента
    int sessionCost = calculateSessionCost(student.getPricePerSession(), student.getTotalSessions());

    // Логіка списання грошей від студента
    int remainingSessions = student.getRemainingSessions();
    int amountToDeduct = remainingSessions > 0 ? sessionCost : 0;

    // Оновлення інформації про студента
    student.setRemainingSessions(remainingSessions - 1);
    studentRepository.save(student);

    // Логіка нарахування викладачу
    int teacherPayment = sessionCost - amountToDeduct;
    teacher.setTotalIncome(teacher.getTotalIncome() + teacherPayment);
    teacherRepository.save(teacher);
  }

  private int calculateSessionCost(int pricePerSession, int totalSessions) {
    // Логіка розрахунку вартості заняття
    return pricePerSession / totalSessions;
  }

  private void calculateTeacherIncome(Teacher teacher) {
    // Логіка розрахунку доходу викладача за період
    // Можливо, вам також знадобиться зберігати історію доходів викладачів
    // Здесь teacher.getTotalIncome() містить загальний дохід викладача
  }
}
