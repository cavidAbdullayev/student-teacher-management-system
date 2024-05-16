package org.example.studentteachermanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.business.request.CreateGroupRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateGroupRequest;
import org.example.studentteachermanagementsystem.business.response.GetGroupResponse;
import org.example.studentteachermanagementsystem.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public void add(@RequestBody @Valid CreateGroupRequest groupRequest) {
        groupService.add(groupRequest);
    }

    @GetMapping("/{id}")
    public GetGroupResponse getById(@PathVariable("id") Integer id) {
        return groupService.getById(id);
    }

    @GetMapping("/get-all")
    public List<GetGroupResponse> getAll() {
        return groupService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        groupService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid UpdateGroupRequest groupRequest) {
        groupService.update(id, groupRequest);
    }
}