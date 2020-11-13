package com.g2.studentservice.application;

import com.g2.studentservice.api.rest.CreateStudentRequest;
import com.g2.studentservice.domain.StudentEntity;

public interface StudentService {
    StudentEntity findStudentById(long studentId);
    StudentEntity create(CreateStudentRequest student);
}
