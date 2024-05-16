package org.example.studentteachermanagementsystem.business.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateGroupRequest {
    @NonNull
    @NotBlank
    @Size(max = 15)
    String groupName;
}