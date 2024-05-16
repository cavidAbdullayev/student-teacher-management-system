package org.example.studentteachermanagementsystem.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    GROUP_EXISTS("Group is already exists by given id!"),
    GROUP_NOT_EXISTS("There are not any group by given id!"),
    STUDENT_NOT_EXISTS_BY_ID("There are not any student by given id!"),
    STUDENT_EXISTS_BY_ID("Student is already exists by given id!"),
    STUDENT_EXISTS_BY_STUDENT_NUMBER("Student is already exists by given student number!"),
    TEACHER_EXISTS_BY_ID("Teacher is already exists by given id!"),
    TEACHER_NOT_EXISTS_BY_ID("There are not any teacher by given id!"),
    INPUT_ERROR("Input is not valid!"),
    SCHOLARSHIP_NEGATIVE("Scholarship must be greater than 0!")

    ;
    private final String message;

    ErrorEnum(String message) {this.message = message;}
}