package com.example.workfinal2.service.GroupService;

import com.example.workfinal2.model.group.Group;
import com.example.workfinal2.repository.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {

  private final GroupRepository groupRepository;

  @Autowired
  public GroupService(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  public Group createGroup(String groupName) {
    groupName = groupName.trim();
    Group existingGroup = groupRepository.findByGroupName(groupName);
    if (existingGroup != null) {
      throw new RuntimeException("Група з іменем " + groupName + " вже існує");
    }

    Group newGroup = new Group();
    newGroup.setGroupName(groupName);
    return groupRepository.save(newGroup);
  }

}
