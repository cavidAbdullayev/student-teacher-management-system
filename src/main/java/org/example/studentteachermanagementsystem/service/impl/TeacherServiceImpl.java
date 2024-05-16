package org.example.studentteachermanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.business.request.CreateTeacherRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateTeacherRequest;
import org.example.studentteachermanagementsystem.business.response.GetTeacherResponse;
import org.example.studentteachermanagementsystem.business.rules.TeacherBusinessRules;
import org.example.studentteachermanagementsystem.entity.Teacher;
import org.example.studentteachermanagementsystem.mappers.ModelMapperService;
import org.example.studentteachermanagementsystem.repository.TeacherRepository;
import org.example.studentteachermanagementsystem.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherBusinessRules teacherBusinessRules;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(CreateTeacherRequest teacherRequest) {
        teacherRepository.save(
                modelMapperService.forRequest()
                        .map(teacherRequest, Teacher.class)
        );
    }

    @Override
    public void delete(Integer id) {
        teacherBusinessRules.checkIfNotExistsById(id);
        teacherRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, UpdateTeacherRequest teacherRequest) {
        teacherBusinessRules.checkIfNotExistsById(id);
        Teacher teacher = teacherRepository.getReferenceById(id);
        if (teacherRequest.getFirstName() != null)
            teacher.setFirstName(teacherRequest.getFirstName());
        if (teacherRequest.getLastName() != null)
            teacher.setLastName(teacherRequest.getLastName());
        if (teacherRequest.getBirthPlace() != null)
            teacher.setBirthPlace(teacherRequest.getBirthPlace());
        if (teacherRequest.getUniversityName() != null)
            teacher.setUniversityName(teacherRequest.getUniversityName());
        if (teacherRequest.getSalary() > 0)
            teacher.setSalary(teacherRequest.getSalary());
        teacherRepository.save(teacher);
    }

    @Override
    public GetTeacherResponse getById(Integer id) {
        teacherBusinessRules.checkIfNotExistsById(id);
        return modelMapperService.forResponse()
                .map(teacherRepository.getReferenceById(id),
                        GetTeacherResponse.class);
    }

    @Override
    public List<GetTeacherResponse> getAll() {
        return teacherRepository.findAll()
                .stream()
                .map(teacher -> modelMapperService
                        .forResponse()
                        .map(teacher, GetTeacherResponse.class))
                .toList();
    }
}