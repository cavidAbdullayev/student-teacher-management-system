package org.example.studentteachermanagementsystem.repository;

import lombok.NonNull;
import org.example.studentteachermanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Boolean existsByStudentNumber(Integer studentNumber);

    boolean existsById(@NonNull Integer id);
}