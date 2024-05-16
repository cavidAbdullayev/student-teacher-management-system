package org.example.studentteachermanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity(name = "group_")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group_ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String groupName;
    @OneToMany(mappedBy = "group")
    List<Student> students;
}