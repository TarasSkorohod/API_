package com.example.workfinal2.service.TeacherService;

import com.example.workfinal2.DTO.TeacherIncomeDTO;
import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.model.teacher.Teacher;
import com.example.workfinal2.repository.GroupRepository;
import com.example.workfinal2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
  private final TeacherRepository teacherRepository;
  private final GroupRepository groupRepository;
  @Autowired
  public TeacherService(TeacherRepository teacherRepository, GroupRepository groupRepository) {
    this.teacherRepository = teacherRepository;
    this.groupRepository = groupRepository;
  }

  public Teacher addTeacherToGroup(Long teacherId, Long groupId) {
    Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
    Optional<Group> optionalGroup = groupRepository.findById(groupId);

    if (optionalTeacher.isPresent() && optionalGroup.isPresent()) {
      Teacher teacher = optionalTeacher.get();
      Group group = optionalGroup.get();

      teacher.getGroups().add(group);
      group.setTeacher(teacher);
      teacherRepository.save(teacher);

      return teacher;
    }

    return null;
  }

  public Teacher createTeacher(Teacher teacher) {
    return teacherRepository.save(teacher);
  }

  public List<TeacherIncomeDTO> calculateTeacherIncome(Long teacherId) {
    // Логіка для розрахунку доходів від викладача
    return Collections.emptyList();
  }
}