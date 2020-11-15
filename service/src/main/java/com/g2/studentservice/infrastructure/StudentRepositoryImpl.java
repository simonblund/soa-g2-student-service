package com.g2.studentservice.infrastructure;

import com.g2.studentservice.domain.StudentEntity;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class StudentRepositoryImpl{

    public Optional<StudentEntity> findById(long studentId) {
        return Optional.of(StudentEntity.builder()
                .studentId(studentId)
                .emailAddress(studentId + "@fakestudent@ltu.se")
                .firstname("Miranda")
                .lastname("Titania")
                .streetAddress("Uranusvägen 3")
                .ssn("101010A2345")
                .createdAt(Instant.now().minus(10, ChronoUnit.DAYS)).build());
    }


}
