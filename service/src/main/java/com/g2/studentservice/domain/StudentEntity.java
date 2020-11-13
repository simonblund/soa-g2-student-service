package com.g2.studentservice.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Builder
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long studentId;

    @Column(unique = true)
    String studentUser;

    @NotNull
    String firstname;

    @NotNull
    String lastname;

    @NotNull
    String ssn;

    String emailAddress;
    String streetAddress;

    @CreatedDate
    Instant createdAt;

}
