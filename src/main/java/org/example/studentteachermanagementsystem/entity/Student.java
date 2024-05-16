package org.example.studentteachermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstName;
    String lastName;
    Integer studentNumber;
    String universityName;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group_ group;
    String birthPlace;
    Double scholarShip;
}