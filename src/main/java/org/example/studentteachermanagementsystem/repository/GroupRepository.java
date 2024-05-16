package org.example.studentteachermanagementsystem.repository;

import lombok.NonNull;
import org.example.studentteachermanagementsystem.entity.Group_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group_,Integer> {
    boolean existsById(@NonNull Integer id);
}