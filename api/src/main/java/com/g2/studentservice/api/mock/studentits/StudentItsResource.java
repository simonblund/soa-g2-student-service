package com.g2.studentservice.api.mock.studentits;

import com.g2.studentservice.api.mock.MockUrlPaths;
import com.g2.studentservice.api.mock.epok.ModulResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface StudentItsResource {

    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.STUDENTITS)
    ResponseEntity<List<StudentItsResponse>> getAllStudents();
}
