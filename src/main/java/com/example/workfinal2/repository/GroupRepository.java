package com.example.workfinal2.repository;

import com.example.workfinal2.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
  Group findByGroupName(String groupName);

}
