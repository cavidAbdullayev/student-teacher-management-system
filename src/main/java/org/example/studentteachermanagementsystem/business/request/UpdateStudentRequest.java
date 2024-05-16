package org.example.studentteachermanagementsystem.business.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {
    @Size(max = 20)
    String firstName;
    @Size(max = 20)
    String lastName;
    Integer studentNumber;
    @Size(max = 50)
    String universityName;
    @Size(max = 30)
    String birthPlace;
    Double scholarShip;
    Integer teacherId;
    Integer groupId;
}