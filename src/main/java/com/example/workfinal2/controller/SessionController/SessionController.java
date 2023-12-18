package com.example.workfinal2.controller.SessionController;

import com.example.workfinal2.model.sessions.Session;
import com.example.workfinal2.service.SessionService.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @PostMapping("/mark-attendance/{sessionId}")
  public ResponseEntity<String> markAttendance(
          @PathVariable Long sessionId,
          @RequestBody List<Long> studentIds
  ) {
    sessionService.markAttendance(sessionId, studentIds);
    return ResponseEntity.ok("Attendance marked successfully");
  }
}