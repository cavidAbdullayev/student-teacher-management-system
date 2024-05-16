package org.example.studentteachermanagementsystem.service.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.business.request.CreateStudentRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateStudentRequest;
import org.example.studentteachermanagementsystem.business.response.GetStudentResponse;
import org.example.studentteachermanagementsystem.business.rules.GroupBusinessRules;
import org.example.studentteachermanagementsystem.business.rules.StudentBusinessRules;
import org.example.studentteachermanagementsystem.business.rules.TeacherBusinessRules;
import org.example.studentteachermanagementsystem.entity.Student;
import org.example.studentteachermanagementsystem.enums.ErrorEnum;
import org.example.studentteachermanagementsystem.exceptions.BusinessRuleExceptions;
import org.example.studentteachermanagementsystem.mappers.ModelMapperService;
import org.example.studentteachermanagementsystem.repository.GroupRepository;
import org.example.studentteachermanagementsystem.repository.StudentRepository;
import org.example.studentteachermanagementsystem.repository.TeacherRepository;
import org.example.studentteachermanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentBusinessRules studentBusinessRules;
    private final ModelMapperService modelMapperService;
    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final GroupBusinessRules groupBusinessRules;
    private final TeacherBusinessRules teacherBusinessRules;

    @Override
    public void add(CreateStudentRequest studentResponse) {
        studentBusinessRules.checkIfStudentExistsByStudentNumber(
                studentResponse.getStudentNumber());
        teacherBusinessRules.checkIfNotExistsById(
                studentResponse.getTeacherId());
        groupBusinessRules.checkIfNotExistsById(
                studentResponse.getGroupId());
        studentRepository.save(modelMapperService.forResponse()
                .map(studentResponse, Student.class));
    }

    @Override
    public void delete(Integer id) {
        studentBusinessRules.checkIfStudentNotExistsById(id);
        studentRepository.deleteById(id);
    }

    @Override
    public GetStudentResponse getById(Integer id) {
        studentBusinessRules.checkIfStudentNotExistsById(id);
        return modelMapperService.forResponse()
                .map(studentRepository.getReferenceById(id),
                        GetStudentResponse.class);
    }

    @Override
    public List<GetStudentResponse> getAll() {
        return studentRepository
                .findAll()
                .stream()
                .map(student -> modelMapperService
                        .forResponse()
                        .map(student, GetStudentResponse.class)).toList();
    }

    @Override
    public void update(Integer id, UpdateStudentRequest studentRequest) {
        studentBusinessRules.checkIfStudentNotExistsById(id);
        Student student = studentRepository.getReferenceById(id);
        if (studentRequest.getStudentNumber() != null)
            student.setStudentNumber(studentRequest.getStudentNumber());
        if (studentRequest.getFirstName() != null)
            student.setFirstName(studentRequest.getFirstName());
        if (studentRequest.getBirthPlace() != null)
            student.setBirthPlace(studentRequest.getBirthPlace());
        if (studentRequest.getLastName() != null)
            student.setLastName(studentRequest.getLastName());
        if (studentRequest.getGroupId() != null){
            groupBusinessRules.checkIfNotExistsById(studentRequest.getGroupId());
            student.setGroup(groupRepository.getReferenceById(studentRequest.getGroupId()));}
        if (studentRequest.getUniversityName() != null)
            student.setUniversityName(studentRequest.getUniversityName());
        if (studentRequest.getScholarShip() != null)
            if(!(studentRequest.getScholarShip()>0))
                throw new BusinessRuleExceptions(ErrorEnum.SCHOLARSHIP_NEGATIVE);
            student.setScholarShip(studentRequest.getScholarShip());
        if (studentRequest.getTeacherId() != null){
            teacherBusinessRules.checkIfNotExistsById(studentRequest.getTeacherId());
            student.setTeacher(teacherRepository.getReferenceById(studentRequest.getTeacherId()));
            }
            studentRepository.save(student);
    }
}