package com.g2.studentservice.interfaces.rest;

import com.g2.studentservice.api.rest.CreateStudentRequest;
import com.g2.studentservice.api.rest.StudentResource;
import com.g2.studentservice.api.rest.StudentResponse;
import com.g2.studentservice.api.rest.UrlPaths;
import com.g2.studentservice.application.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class StudentController implements StudentResource {

    private final StudentService service;

    @Override
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

    @Override
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
