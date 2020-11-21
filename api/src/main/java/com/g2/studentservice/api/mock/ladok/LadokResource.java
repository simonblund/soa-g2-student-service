package com.g2.studentservice.api.mock.ladok;

import com.g2.studentservice.api.mock.MockUrlPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface LadokResource {
    @RequestMapping(method = RequestMethod.GET, path = MockUrlPaths.LADOK)
    ResponseEntity<ResultResponse> getResult();

    @RequestMapping(method = RequestMethod.PATCH, path = MockUrlPaths.LADOK+"{id}")
    ResponseEntity<ResultResponse> setResult(@PathVariable String id, @RequestBody ResultResponse body);
}