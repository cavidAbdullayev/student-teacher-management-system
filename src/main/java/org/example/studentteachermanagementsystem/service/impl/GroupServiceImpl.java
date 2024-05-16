package org.example.studentteachermanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.business.request.CreateGroupRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateGroupRequest;
import org.example.studentteachermanagementsystem.business.response.GetGroupResponse;
import org.example.studentteachermanagementsystem.business.rules.GroupBusinessRules;
import org.example.studentteachermanagementsystem.entity.Group_;
import org.example.studentteachermanagementsystem.mappers.ModelMapperService;
import org.example.studentteachermanagementsystem.repository.GroupRepository;
import org.example.studentteachermanagementsystem.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupBusinessRules groupBusinessRules;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(CreateGroupRequest groupRequest) {
        groupRepository.save(modelMapperService
                .forRequest()
                .map(groupRequest, Group_.class));
    }

    @Override
    public void delete(Integer id) {
        groupBusinessRules.checkIfNotExistsById(id);
        groupRepository.deleteById(id);
    }

    @Override
    public GetGroupResponse getById(Integer id) {
        groupBusinessRules.checkIfNotExistsById(id);
        return modelMapperService.forResponse()
                .map(groupRepository.getReferenceById(id),
                        GetGroupResponse.class);
    }

    @Override
    public List<GetGroupResponse> getAll() {
        return groupRepository.findAll()
                .stream()
                .map(group -> modelMapperService
                        .forResponse()
                        .map(group, GetGroupResponse.class))
                .toList();
    }

    @Override
    public void update(Integer id, UpdateGroupRequest groupRequest) {
        groupBusinessRules.checkIfNotExistsById(id);
        groupRepository.save(modelMapperService
                .forRequest()
                .map(groupRequest, Group_.class));
    }
}