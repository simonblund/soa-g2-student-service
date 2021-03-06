package com.g2.studentservice.application;

import com.g2.studentservice.api.mock.studentits.StudentItsResponse;
import com.g2.studentservice.api.rest.CreateStudentRequest;
import com.g2.studentservice.domain.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity findStudentById(long studentId);

    StudentEntity findStudentByStudentUser(String studentUser);

    StudentEntity create(CreateStudentRequest student);

    List<StudentItsResponse> getAllStudents();

    StudentEntity getStudent(String studentUser);

    StudentEntity getStudentFromSsn(String ssn);
}
