package org.example.studentteachermanagementsystem.exceptions;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValidationErrorInfo extends ProblemInfo{
    Map<String,String>validationErrorInfos;
}
