package org.example.studentteachermanagementsystem.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentResponse {
    String firstName;
    String lastName;
    Integer studentNumber;
    String universityNumber;
    Integer teacherId;
    Integer groupId;
    String birthPlace;
    Double scholarShip;
}