package com.g2.studentservice.infrastructure.rest;

import com.g2.studentservice.api.mock.studentits.StudentItsResource;
import com.g2.studentservice.api.mock.studentits.StudentItsResponse;
import com.g2.studentservice.api.rest.StudentResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "studentits-client", url = "${integration.services.mock-service.url}")
public interface StudentItsClient extends StudentItsResource {

}
