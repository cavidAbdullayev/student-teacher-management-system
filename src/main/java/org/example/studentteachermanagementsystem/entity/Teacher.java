package org.example.studentteachermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    String universityName;
    Double salary;
    String birthPlace;
    @OneToMany(mappedBy = "teacher")
    List<Student> students;
}