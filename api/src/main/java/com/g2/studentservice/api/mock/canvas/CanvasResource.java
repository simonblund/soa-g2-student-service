package com.g2.studentservice.api.mock.canvas;

import com.g2.studentservice.api.mock.MockUrlPaths;
import com.g2.studentservice.api.mock.ladok.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CanvasResource {
    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.CANVAS)
    ResponseEntity<AssignmentResponse> getAssignments();
}
