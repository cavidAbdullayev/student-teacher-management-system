package org.example.studentteachermanagementsystem.business.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStudentRequest {
    @NonNull
    @NotBlank
    @Size(max = 20)
    String firstName;
    @NonNull
    @NotBlank
    @Size(max = 20)
    String lastName;
    @NonNull
    Integer studentNumber;
    @NonNull
    @Size(max = 50)
    @NotBlank
    String universityName;
    @NonNull
    Integer teacherId;
    @NotNull
    Integer groupId;
    @NonNull
    @NotBlank
    @Size(max = 30)
    String birthPlace;
    @NonNull
    Double scholarShip;
}