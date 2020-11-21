package com.g2.studentservice.api.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface StudentResource {
    @RequestMapping(method = RequestMethod.GET, path = UrlPaths.STUDENT_GET)
    ResponseEntity<StudentResponse> getStudent(@PathVariable("studentId") long studentId);

    @RequestMapping(method = RequestMethod.POST, path = UrlPaths.SSN_FROM_STUDENTUSER)
    ResponseEntity<SsnAndStudentUserResponse> getSsnFromStudentUser(@RequestBody SsnFromStudentUserRequest request);

    @RequestMapping(method = RequestMethod.POST, path = UrlPaths.STUDENT_CREATE)
    ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentRequest request);

    @PostMapping(UrlPaths.STUDENTUSER_FROM_SSN)
    ResponseEntity<SsnAndStudentUserResponse> getStudentUserFromSsn(@RequestBody StudentUserFromSsnRequest request);
}
