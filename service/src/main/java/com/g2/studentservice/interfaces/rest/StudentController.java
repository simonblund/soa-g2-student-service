package com.g2.studentservice.interfaces.rest;

import com.g2.studentservice.api.rest.StudentResource;
import com.g2.studentservice.api.rest.StudentResponse;
import com.g2.studentservice.api.rest.UrlPaths;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudentController implements StudentResource{

    @GetMapping(UrlPaths.STUDENT_RESOURCE)
    @ExceptionHandler
    public ResponseEntity<StudentResponse> getStudent(@PathVariable("id") String studentId){
        log.debug("getStudent hit with request studentId: {}", studentId);
        if(studentId.contains("test-01")){
            val student = StudentResponse.builder().firstName("Svanmon").email("svan@mon.ax").ssn("121294-193R").studentId(studentId).build();
            return ResponseEntity.ok(student);
        }

        throw new RuntimeException();

    }

}
