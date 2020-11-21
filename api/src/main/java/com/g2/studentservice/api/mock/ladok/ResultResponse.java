package com.g2.studentservice.api.mock.ladok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {
    private String ssn;
    private String courseCode;
    private String module;
    private String date;
    private Grade grade;
}
