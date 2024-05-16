package org.example.studentteachermanagementsystem.exceptions;

import org.example.studentteachermanagementsystem.enums.ErrorEnum;

public class BusinessRuleExceptions extends RuntimeException {
    public BusinessRuleExceptions(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
}