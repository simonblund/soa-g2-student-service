package com.g2.studentservice.api.rest;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SsnAndStudentUserResponse {
    private String ssn;
    private String studentUser;
}
