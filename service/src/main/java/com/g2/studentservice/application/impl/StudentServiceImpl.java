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
    public StudentEntity findStudentByStudentUser(String studentUser) {
        val student = client.getStudentFromStudentUser(studentUser).getBody().get(0);

        return StudentEntity.builder()
                .firstname(student.getFirstName())
                .lastname(student.getLastName())
                .studentUser(student.getStudentUser())
                .ssn(student.getSsn())
                .build();
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
        val students = client.getAllStudents().getBody();
        return students;
    }


    @Override
    public StudentEntity getStudent(String studentUser){
        val students = client.getAllStudents().getBody();
        students.forEach(it -> {log.info("studentuser "+it.getStudentUser()+" person "+it.getSsn());});
        val studentIts = students.stream().filter(it -> it.getStudentUser().equals(studentUser)).findFirst().get();

        val student = StudentEntity.builder().ssn(studentIts.getSsn()).studentUser(studentIts.getStudentUser()).build();

        return student;
    }

    @Override
    public StudentEntity getStudentFromSsn(String ssn){
        val students = client.getAllStudents().getBody();
        students.forEach(it -> {log.info("studentuser "+it.getStudentUser()+" person "+it.getSsn());});
        val studentIts = students.stream().filter(it -> it.getSsn().equals(ssn)).findFirst().get();

        val student = StudentEntity.builder().ssn(studentIts.getSsn()).studentUser(studentIts.getStudentUser()).build();

        return student;
    }
}
