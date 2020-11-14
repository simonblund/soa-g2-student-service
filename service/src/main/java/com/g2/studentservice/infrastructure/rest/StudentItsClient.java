package com.g2.studentservice.infrastructure.rest;

import com.g2.studentservice.api.mock.epok.EpokModulResource;
import com.g2.studentservice.api.mock.epok.ModulResponse;
import com.g2.studentservice.api.mock.studentits.StudentItsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="studentits-client", url = "${integration.services.mock-service.url}")
public interface StudentItsClient {
    @GetMapping("/student")
    List<StudentItsResponse> getAllStudents();
}
