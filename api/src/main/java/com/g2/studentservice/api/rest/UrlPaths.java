package com.g2.studentservice.api.rest;

public class UrlPaths {
    public static final String BASE_URI = "/student-service/";
    public static final String V1 = "V1/";
    public static final String STUDENT_GET = BASE_URI + V1 + "student/{studentId}";
    public static final String STUDENT_CREATE = BASE_URI + V1 + "student/create";

    public static final String SSN_FROM_STUDENTUSER = BASE_URI + V1 + "util/ssn";
    public static final String STUDENTUSER_FROM_SSN = BASE_URI + V1 + "util/student-user";
}
