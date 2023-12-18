package com.example.workfinal2.service.TeacherService;

import com.example.workfinal2.model.TeacherStatistics.TeacherStatistics;
import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.student.Student;
import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.repository.GroupRepository;
import com.example.workfinal2.repository.StudentRepository;
import com.example.workfinal2.repository.TeacherRepository;
import com.example.workfinal2.repository.TeacherStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TeacherStatisticsService {

  private final TeacherRepository teacherRepository;
  private final StudentRepository studentRepository;
  private final GroupRepository groupRepository;
  private final TeacherStatisticsRepository teacherStatisticsRepository;

  @Autowired
  public TeacherStatisticsService(TeacherRepository teacherRepository,
                                  StudentRepository studentRepository,
                                  GroupRepository groupRepository,
                                  TeacherStatisticsRepository teacherStatisticsRepository) {
    this.teacherRepository = teacherRepository;
    this.studentRepository = studentRepository;
    this.groupRepository = groupRepository;
    this.teacherStatisticsRepository = teacherStatisticsRepository;
  }

  @Transactional
  public void updateTeacherStatistics(Long teacherId, Date sessionDate) {
    Teacher teacher = teacherRepository.findById(teacherId)
            .orElseThrow(() -> new RuntimeException("Teacher not found"));

    List<Group> groups = groupRepository.findByTeacher(teacher);
    List<Student> students = studentRepository.findByGroupIn(groups);

    for (Student student : students) {
      TeacherStatistics teacherStatistics = new TeacherStatistics();
      teacherStatistics.setTeacher(teacher);
      teacherStatistics.setSessionDate(sessionDate);
      teacherStatistics.setGroupSessions(0);
      teacherStatistics.setIndividualSessions(0);
      teacherStatistics.setSalaryEarned(0);
      teacherStatistics.setTotalSessionCost(0);
      teacherStatistics.setSchoolEarnings(0);

      // Ваші логіки для підрахунку статистики
      // Приклад:
      if (student.getPaymentType() == Student.PaymentType.GROUP) {
        teacherStatistics.setGroupSessions(student.getSessionsPerCourse());
      } else {
        teacherStatistics.setIndividualSessions(student.getSessionsPerCourse());
      }

      teacherStatistics.setTotalSessionCost(student.getCoursePrice() * student.getSessionsPerCourse());
      teacherStatistics.setSalaryEarned(teacherStatistics.getTotalSessionCost() * teacher.getPaymentRate() / 100);
      teacherStatistics.setSchoolEarnings(teacherStatistics.getTotalSessionCost() - teacherStatistics.getSalaryEarned());

      // Збереження статистики в базу даних
      teacherStatisticsRepository.save(teacherStatistics);
    }
  }
}
