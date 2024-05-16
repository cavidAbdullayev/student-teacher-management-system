package org.example.studentteachermanagementsystem.business.rules;

import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.enums.ErrorEnum;
import org.example.studentteachermanagementsystem.exceptions.BusinessRuleExceptions;
import org.example.studentteachermanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentBusinessRules {
    private final StudentRepository studentRepository;

    public void checkIfStudentNotExistsById(Integer id) {
        if (!studentRepository.existsById(id))
            throw new BusinessRuleExceptions(ErrorEnum.STUDENT_NOT_EXISTS_BY_ID);
    }

    public void checkIfStudentExistsByStudentNumber(Integer studentNumber) {
        if (studentRepository.existsByStudentNumber(studentNumber)) {
            throw new
                    BusinessRuleExceptions(ErrorEnum.STUDENT_EXISTS_BY_STUDENT_NUMBER);
        }
    }


}