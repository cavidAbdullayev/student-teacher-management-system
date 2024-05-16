package org.example.studentteachermanagementsystem.business.rules;

import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.enums.ErrorEnum;
import org.example.studentteachermanagementsystem.exceptions.BusinessRuleExceptions;
import org.example.studentteachermanagementsystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherBusinessRules {
    private final TeacherRepository teacherRepository;

    public void checkIfExistsById(Integer id) {
        if (teacherRepository.existsById(id))
            throw new BusinessRuleExceptions(ErrorEnum.TEACHER_EXISTS_BY_ID);
    }

    public void checkIfNotExistsById(Integer id) {
        if (!teacherRepository.existsById(id))
            throw new BusinessRuleExceptions(ErrorEnum.TEACHER_NOT_EXISTS_BY_ID);
    }
}