package com.g2.studentservice.api.mock.canvas;

import com.g2.studentservice.api.mock.MockUrlPaths;
import com.g2.studentservice.api.mock.ladok.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface CanvasResource {
    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.CANVAS)
    ResponseEntity<List<AssignmentResponse>> getAssignments();

    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.CANVAS+"?assignment_id={assignmentId}")
    ResponseEntity<AssignmentResponse> getAssignment(@PathVariable String assignmentId);

    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.CANVAS+"?module_id={moduleCode}")
    ResponseEntity<List<AssignmentResponse>> getAssignmentsForExamination(String moduleCode);
}
