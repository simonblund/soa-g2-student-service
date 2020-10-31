package com.g2.studentservice.api.rest;

import org.springframework.http.ResponseEntity;

public interface StudentResource {
    ResponseEntity<StudentResponse> getStudent(String studentId);
}
