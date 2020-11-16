package com.g2.studentservice.interfaces.rest;

import com.g2.studentservice.api.rest.*;
import com.g2.studentservice.application.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class StudentController {

    private final StudentService service;


    @GetMapping(UrlPaths.STUDENT_GET)
    public ResponseEntity<StudentResponse> getStudent(@PathVariable("studentId") long studentId) {
        try {
            log.debug("getStudent hit with request studentId: {}", studentId);
            val student = service.findStudentById(studentId);

            return ResponseEntity.ok(StudentResponse.builder()
                    .studentId(student.getStudentId())
                    .ssn(student.getSsn())
                    .firstName(student.getFirstname())
                    .email(student.getEmailAddress())
                    .studentUser(student.getStudentUser()).build());


        } catch (Exception e) {
            log.warn("Get student from studentId failed: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    @PostMapping(UrlPaths.SSN_FROM_STUDENTUSER)
    public ResponseEntity<SsnAndStudentUserResponse> getSsnFromStudentUser(@RequestBody SsnFromStudentUserRequest request) {
        try {
            log.debug("getStudent hit with request studentId: {}", request.getStudentUser());
            val student = service.getStudent(request.getStudentUser());

            return ResponseEntity.ok(SsnAndStudentUserResponse.builder().ssn(student.getSsn()).studentUser(student.getStudentUser()).build());


        } catch (Exception e) {
            log.warn("Get student from studentId failed: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }

    @PostMapping(UrlPaths.STUDENTUSER_FROM_SSN)
    public ResponseEntity<SsnAndStudentUserResponse> getStudentUserFromSsn(@RequestBody StudentUserFromSsnRequest request) {
        try {
            log.debug("getStudent hit with request studentUser: {}", request.getSsn());
            val student = service.getStudentFromSsn(request.getSsn());

            return ResponseEntity.ok(SsnAndStudentUserResponse.builder().ssn(student.getSsn()).studentUser(student.getStudentUser()).build());


        } catch (Exception e) {
            log.warn("Get student from studentId failed: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }

    }


    @PostMapping(UrlPaths.STUDENT_CREATE)
    public ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentRequest request){
        try{
            val student = service.create(request);
            return ResponseEntity.ok(StudentResponse.builder()
                    .studentId(student.getStudentId())
                    .ssn(student.getSsn())
                    .firstName(student.getFirstname())
                    .email(student.getEmailAddress())
                    .studentUser(student.getStudentUser()).build());
        } catch (Exception e){
            log.warn("Create student failed: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
