package com.example.workfinal2.repository;


import com.example.workfinal2.model.sessions.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
  // Додайте методи для роботи із заняттями, які можуть бути потрібні
}
