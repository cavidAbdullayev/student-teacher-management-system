package org.example.studentteachermanagementsystem.service;

import org.example.studentteachermanagementsystem.business.request.CreateStudentRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateStudentRequest;
import org.example.studentteachermanagementsystem.business.response.GetStudentResponse;

import java.util.List;

public interface StudentService {
    void add(CreateStudentRequest studentResponse);

    void delete(Integer id);

    GetStudentResponse getById(Integer id);

    List<GetStudentResponse> getAll();

    void update(Integer id, UpdateStudentRequest studentRequest);
}