
package com.example.demo.controller;
public class StudentProfileController{
       package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profiles")
public class StudentProfileController {

    private final StudentProfileRepository studentRepo;

    public StudentProfileController(StudentProfileRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile student) {
        return studentRepo.save(student);
    }


    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentRepo.findAll();
    }

    @PutMapping("/{studentId}/repeat-status")
    public StudentProfile updateRepeatStatus(
            @PathVariable Long studentId,
            @RequestParam boolean repeatOffender) {

        StudentProfile student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setRepeatOffender(repeatOffender);
        return studentRepo.save(student);
    }


    @GetMapping("/lookup/{studentIdentifier}")
    public StudentProfile findByStudentIdentifier(
            @PathVariable String studentIdentifier) {

        return studentRepo.findByStudentIdentifier(studentIdentifier)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}

  }
