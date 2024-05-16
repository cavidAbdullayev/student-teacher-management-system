package org.example.studentteachermanagementsystem.repository;

import lombok.NonNull;
import org.example.studentteachermanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    boolean existsById(@NonNull Integer id);
}