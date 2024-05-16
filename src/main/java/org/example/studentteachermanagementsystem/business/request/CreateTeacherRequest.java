package org.example.studentteachermanagementsystem.business.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTeacherRequest {
    @NonNull
    @NotBlank
    @Size(max = 20)
    String firstName;
    @NonNull
    @NotBlank
    @Size(max = 20)
    String lastName;
    @NonNull
    @NotBlank
    @Size(max = 50)
    String universityName;
    @NonNull
    Double salary;
    @NonNull
    @NotBlank
    @Size(max = 40)
    String birthPlace;
}