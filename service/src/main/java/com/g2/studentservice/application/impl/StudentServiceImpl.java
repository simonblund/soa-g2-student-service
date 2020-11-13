package com.g2.studentservice.application.impl;

import com.g2.studentservice.api.rest.CreateStudentRequest;
import com.g2.studentservice.application.StudentService;
import com.g2.studentservice.domain.StudentEntity;
import com.g2.studentservice.infrastructure.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository repository;

    @Override
    public StudentEntity findStudentById(long studentId) {
        return repository.findById(studentId).get();
    }

    @Override
    public StudentEntity create(CreateStudentRequest request){
        String studentUser = studentUserGenerator(request.getFirstname(), request.getLastname());
        val student = StudentEntity.builder()
                .studentUser(studentUser)
                .emailAddress(studentUser+"@fake.ltu.se")
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .ssn(request.getSsn())
                .streetAddress(request.getStreetAdress()).build();
        return repository.save(student);
    }

    private String studentUserGenerator(String firstname, String lastname){
        Random random = new Random();
        int number = random.nextInt(200 - 2)+2;
        return firstname.substring(0,2)+ lastname.substring(0,3)+"-"+number;
    }
}
