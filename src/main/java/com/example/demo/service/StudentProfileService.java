package com.example.demo.service
package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createData(Student student);

    List<Student> fetchRecord();

    Optional<Student> fetchDataById(int id);

    Student updateRepeatStatus(int studentId, boolean repeatOffender);

    Student findByStudentIdentifier(String studentIdentifier);
}
