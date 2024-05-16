package org.example.studentteachermanagementsystem.service;

import org.example.studentteachermanagementsystem.business.request.CreateTeacherRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateTeacherRequest;
import org.example.studentteachermanagementsystem.business.response.GetTeacherResponse;

import java.util.List;

public interface TeacherService {
    void add(CreateTeacherRequest teacherRequest);

    void delete(Integer id);

    void update(Integer id, UpdateTeacherRequest teacherRequest);

    GetTeacherResponse getById(Integer id);

    List<GetTeacherResponse> getAll();
}