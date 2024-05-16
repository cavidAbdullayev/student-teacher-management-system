package org.example.studentteachermanagementsystem.business.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UpdateTeacherRequest {
    @Size(max = 20)
    String firstName;
    @Size(max = 20)
    String lastName;
    @Size(max = 50)
    String universityName;
    Double salary;
    @Size(max = 40)
    String birthPlace;
}