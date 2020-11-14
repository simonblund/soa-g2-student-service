package com.g2.studentservice.application.impl;

import com.g2.studentservice.api.mock.studentits.StudentItsResponse;
import com.g2.studentservice.api.rest.CreateStudentRequest;
import com.g2.studentservice.application.StudentService;
import com.g2.studentservice.domain.StudentEntity;
import com.g2.studentservice.infrastructure.StudentRepository;
import com.g2.studentservice.infrastructure.rest.StudentItsClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository repository;


    private final StudentItsClient client;

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

    @Override
    public List<StudentItsResponse> getAllStudents(){
        val students = client.getAllStudents();
        return students;
    }

    @Override
    public StudentItsResponse getStudentItsSsn(String studentUser){
        val students = client.getAllStudents();
        students.forEach(it -> {log.warn("studentuser "+it.getStudentUser()+" person "+it.getPnr());});
        val student = students.stream().filter(it -> it.getStudentUser().equals(studentUser)).findFirst();
        return student.get();
    }
}
