package org.example.studentteachermanagementsystem.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeacherResponse {
    String firstName;
    String lastName;
    String universityName;
    Double salary;
    String birthPlace;
}