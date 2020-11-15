package com.g2.studentservice.application;

import com.g2.studentservice.api.mock.studentits.StudentItsResponse;
import com.g2.studentservice.api.rest.CreateStudentRequest;
import com.g2.studentservice.domain.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity findStudentById(long studentId);
    StudentEntity create(CreateStudentRequest student);

    List<StudentItsResponse> getAllStudents();

    StudentItsResponse getStudentItsSsn(String studentUser);
}
