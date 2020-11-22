package com.g2.studentservice.infrastructure.rest;

import com.g2.studentservice.api.mock.MockUrlPaths;
import com.g2.studentservice.api.mock.studentits.StudentItsResource;
import com.g2.studentservice.api.mock.studentits.StudentItsResponse;
import com.g2.studentservice.api.rest.StudentResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "studentits-client", url = "${integration.services.mock-service.url}")
public interface StudentItsClient extends StudentItsResource {

    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.STUDENTITS + "?username={id}")
    ResponseEntity<List<StudentItsResponse>> getStudentFromStudentUser(@PathVariable String id);
}
