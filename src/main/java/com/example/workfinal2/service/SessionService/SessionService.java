package com.example.workfinal2.service.SessionService;

import com.example.workfinal2.model.sessions.Session;
import com.example.workfinal2.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
  private final SessionRepository sessionRepository;

  @Autowired
  public SessionService(SessionRepository sessionRepository) {
    this.sessionRepository = sessionRepository;
  }

  public Session createSession(Session session) {
    // Логіка для створення заняття
    return sessionRepository.save(session);
  }

  public void markAttendance(Long sessionId, List<Long> studentIds) {
    // Логіка відмітки присутності студентів на занятті
  }
}
