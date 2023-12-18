package com.example.workfinal2.repository;

import com.example.workfinal2.model.TeacherStatistics.TeacherStatistics;
import com.example.workfinal2.model.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherStatisticsRepository  extends JpaRepository<TeacherStatistics, Long> {
}
