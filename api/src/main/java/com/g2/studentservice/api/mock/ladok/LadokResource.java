package com.g2.studentservice.api.mock.ladok;

import com.g2.studentservice.api.mock.MockUrlPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface LadokResource {
    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.LADOK)
    ResponseEntity<ResultResponse> getResult();
}