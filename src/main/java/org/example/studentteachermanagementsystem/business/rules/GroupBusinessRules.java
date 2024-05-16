package org.example.studentteachermanagementsystem.business.rules;

import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.enums.ErrorEnum;
import org.example.studentteachermanagementsystem.exceptions.BusinessRuleExceptions;
import org.example.studentteachermanagementsystem.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupBusinessRules {
    private final GroupRepository groupRepository;

    public void checkIfExistsById(Integer id) {
        if (groupRepository.existsById(id))
            throw new BusinessRuleExceptions(ErrorEnum.GROUP_EXISTS);
    }

    public void checkIfNotExistsById(Integer id) {
        if (!groupRepository.existsById(id))
            throw new BusinessRuleExceptions(ErrorEnum.GROUP_NOT_EXISTS);
    }
}