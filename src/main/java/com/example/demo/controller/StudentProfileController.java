package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.dto.StudentRequests;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentRequests request) {
        StudentProfile student = new StudentProfile();
        student.setStudentId(request.getStudentId());
        student.setEmail(request.getEmail());
        student.setProgram(request.getProgram());
        student.setYearLevel(request.getYearLevel());
        student.setRepeatOffender(false);
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}/update-repeat")
    public void updateRepeatOffenderStatus(@PathVariable Long id) {
        service.updateRepeatOffenderStatus(id);
    }
}
