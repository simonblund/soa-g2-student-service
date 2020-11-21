package com.g2.studentservice.api.mock.canvas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.g2.studentservice.api.mock.ladok.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponse {
    private String assignmentId;
    private String studentId;
    private Grade grade;
    private String moduleId;
    private String teacherId;
    private LocalDate createdAt;
}
