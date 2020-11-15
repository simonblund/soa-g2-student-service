package com.g2.studentservice.api.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface StudentResource {
    @RequestMapping(method = RequestMethod.GET, path = UrlPaths.STUDENT_GET)
    ResponseEntity<StudentResponse> getStudent(@PathVariable("studentId") long studentId);

    @RequestMapping(method = RequestMethod.POST, path = UrlPaths.SSN_FROM_STUDENTUSER)
    ResponseEntity<SsnAndStudentUserResponse> getSsnFromStudentUser(@RequestBody SsnFromStudentUserRequest request);

    @RequestMapping(method = RequestMethod.POST, path = UrlPaths.STUDENT_CREATE)
    ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentRequest request);
}
