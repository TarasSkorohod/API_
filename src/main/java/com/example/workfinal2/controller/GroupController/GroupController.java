package com.example.workfinal2.controller.GroupController;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.service.GroupService.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/groups")
public class GroupController {
  private final GroupService groupService;

  @Autowired
  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @PostMapping("/create")
  public ResponseEntity<Group> createGroup(@RequestBody String groupName) {
    try {
      Group createdGroup = groupService.createGroup(groupName.trim()); // Видаляємо зайві пробіли з початку і в кінці
      return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
