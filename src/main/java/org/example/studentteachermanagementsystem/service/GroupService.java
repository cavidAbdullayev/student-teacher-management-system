package org.example.studentteachermanagementsystem.service;

import org.example.studentteachermanagementsystem.business.request.CreateGroupRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateGroupRequest;
import org.example.studentteachermanagementsystem.business.response.GetGroupResponse;

import java.util.List;

public interface GroupService {
    void add(CreateGroupRequest groupRequest);

    void delete(Integer id);

    GetGroupResponse getById(Integer id);

    List<GetGroupResponse> getAll();

    void update(Integer id, UpdateGroupRequest groupRequest);
}