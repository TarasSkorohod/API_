package com.example.workfinal2.controller.SessionController;

import com.example.workfinal2.model.sessions.Session;
import com.example.workfinal2.service.SessionService.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sessions")
public class SessionController {
  private final SessionService sessionService;

  @Autowired
  public SessionController(SessionService sessionService) {
    this.sessionService = sessionService;
  }

  @PostMapping
  public ResponseEntity<Session> createSession(@RequestBody Session session) {
    Session createdSession = sessionService.createSession(session);
    return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
  }

  // Додайте інші ендпойнти для роботи зі заняттями
}