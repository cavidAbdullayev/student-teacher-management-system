package org.example.studentteachermanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.business.request.CreateTeacherRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateTeacherRequest;
import org.example.studentteachermanagementsystem.business.response.GetTeacherResponse;
import org.example.studentteachermanagementsystem.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public void add(@RequestBody @Valid CreateTeacherRequest teacherRequest) {
        teacherService.add(teacherRequest);
    }

    @GetMapping("/{id}")
    public GetTeacherResponse getById(@PathVariable("id") Integer id) {
        return teacherService.getById(id);
    }

    @GetMapping("get-all")
    public List<GetTeacherResponse> getAll() {
        return teacherService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        teacherService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody UpdateTeacherRequest teacherRequest) {
        teacherService.update(id, teacherRequest);
    }
}