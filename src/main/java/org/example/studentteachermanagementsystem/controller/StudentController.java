package org.example.studentteachermanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentteachermanagementsystem.business.request.CreateStudentRequest;
import org.example.studentteachermanagementsystem.business.request.UpdateStudentRequest;
import org.example.studentteachermanagementsystem.business.response.GetStudentResponse;
import org.example.studentteachermanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public GetStudentResponse getById(@PathVariable("id") Integer id) {
        return studentService.getById(id);
    }

    @GetMapping("/get-all")
    public List<GetStudentResponse> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid UpdateStudentRequest studentRequest) {
        studentService.update(id, studentRequest);
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateStudentRequest studentRequest) {
        studentService.add(studentRequest);
    }
}